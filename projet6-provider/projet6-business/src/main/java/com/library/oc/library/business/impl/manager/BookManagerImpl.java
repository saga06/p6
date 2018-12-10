package com.library.oc.library.business.impl.manager;

import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.book.Reservation;
import com.library.oc.library.model.bean.book.ReservationWithEmail;
import com.library.oc.library.model.bean.user.User;

import javax.inject.Named;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Named
public class BookManagerImpl extends AbstractManager implements BookManager {

    @Override
    public List<Book> displayAllBooks() {
        List<Book> books = getDaoFactory().getBookDao().findAllBooks();
        for(Book book : books)
        {
            buildBookDependencies(book);
        }
        return books;
    }



    @Override
    public List<BookBorrowed> getListBookBorrowedByUser(Integer id) {
        List<BookBorrowed> booksBorrowed = getDaoFactory().getBookBorrowedDao().findAllBooksBorrowed(id);
        for(BookBorrowed bookBorrowed : booksBorrowed)
        {
            buildBookBorrowedDependencies(bookBorrowed);
        }
        return booksBorrowed;
    }

    @Override
    public void buildBookDependencies(Book book) {

        book.setAuthors(getDaoFactory().getAuthorDao().findAuthorsByBook(book));
        book.setThemes(getDaoFactory().getThemeDao().findThemesByBook(book));
        book.setNbOfCopiesAlreadyBorrowed(getDaoFactory().getBookDao().getNbOfCopiesAlreadyBorrowed(book));
        book.setNbOfCopiesAvailable(getNbOfCopiesAvailableForABook(book));
    }


    @Override
    public void buildBookBorrowedDependencies(BookBorrowed bookBorrowed)

    {
        bookBorrowed.setAuthors(getDaoFactory().getAuthorDao().findAuthorsByBook(bookBorrowed));
        bookBorrowed.setThemes(getDaoFactory().getThemeDao().findThemesByBook(bookBorrowed));
        bookBorrowed.setNbOfCopiesAlreadyBorrowed(getDaoFactory().getBookBorrowedDao().getNbOfCopiesAlreadyBorrowed(bookBorrowed));
        bookBorrowed.setNbOfCopiesAvailable(getNbOfCopiesAvailableForABookBorrowed(bookBorrowed));

    }

    @Override
    public List<ReservationWithEmail> getListReservationWithEmailAndBook() {

        // 1: Récupérer la liste des réservations "actives" (toujours d'actualité)
        List<Reservation> reservationsActive = getDaoFactory().getBookDao().findAllActiveReservation();
        System.out.println("il y a " + reservationsActive.size() + " reservation(s) active(s)");

        // 2 : Récupérer la liste des réservations actives AVEC des ouvrages disponibles et créer une liste reservationsAvailable
        List<Reservation> reservationsAvailable = new ArrayList<>();
        for (Reservation reservation : reservationsActive) {
            // we get the id of the book reserved
            int idBook = reservation.getIdBook();
            // we get the object book with the id (bc we need the entire objet for the method getNbOfCopie...)
            Book bookReserved = getDaoFactory().getBookDao().read(idBook);
            buildBookDependencies(bookReserved);

            // we get the number of book available
            Integer nbAvailable = bookReserved.getNbOfCopiesAvailable();

            if (nbAvailable > 0) {
                System.out.println("il y a une réservation pour le livre " + bookReserved.getTitle() + " qui est disponible");
            } else {
                System.out.println("il n'y a pas d'exemplaire disponible de " + bookReserved.getTitle());
            }

            // if the book is available, we add the reservation in the list of reservationsAvailable
            if (nbAvailable > 0) {
                reservationsAvailable.add(reservation);
                System.out.println("il y a une réservation qui peut etre honoree");
            }
        }

        // 3 : Pour chaque réservation active et dispo, on chercher quelle est la réservation la plus ancienne
        // ie, la réservation qui a été faite en premier, et donc la première à devoir etre honorer
        List<ReservationWithEmail> oldestReservationByBookList = new ArrayList<>();
        List<Integer> idsBook = new ArrayList<>();
        for (Reservation oldestReservationByBook : reservationsAvailable) {
            // we get the id of the book
            int idBook = oldestReservationByBook.getIdBook();
            // we use the orberBy to get ONLY the oldest reservation information by book
            // Ici une méthode en pure sql est appelée. C'est elle qui sélectionne la réservation la plus ancienne
            // pour une livre donné (un id)
            ReservationWithEmail oldestReservationForABook = getOldestUserReservationForABook(idBook);
            if (oldestReservationForABook != null) {
                int idBook2 = oldestReservationForABook.getIdBook();
                if (!idsBook.contains(idBook2)) {
                    idsBook.add(idBook2);
                    oldestReservationByBookList.add(oldestReservationForABook);
                }
            }
        }
        System.out.println("il y a au total " + oldestReservationByBookList.size() + " email(s) à envoyer");

        // Now we have to check that this reservation has been done under 48 hours :

        // 2nd list : list of resa without resa older than 48hours :
        List<ReservationWithEmail> finalList = new ArrayList<ReservationWithEmail>();

        for (ReservationWithEmail reservation : oldestReservationByBookList) {
            // 1 : for each reservation, we check that we never send an email (and so the reservation is still active)
            Boolean emailAlreadySend = reservation.getEmailSend();

            if (!emailAlreadySend) {
                // 2 : for each reservation, if we never send an email, we add the resa to the secondListResa (the email batch list)
                finalList.add(reservation);
                // 3 and we update the status of their email (alreadySend to true)
                updateEmailStatus(reservation.getId());
            } else {   // if we already send an email, we check that it's not older than 48hours
                // dateSend = datetime when the email was send
                Date dateSend = (reservation.getDateOfEmail()).getTime();

                // get current date
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date currentDate = new Date();

                System.out.println(dateFormat.format(dateSend));
                System.out.println(dateFormat.format(currentDate));

                // check delta time between 1st email send and now
                long deltaInMilliseconds = currentDate.getTime() - dateSend.getTime();
                System.out.println(deltaInMilliseconds);

                // 2 days in milliseconds is 1,728^8, if delta > to this, then the reservation has more than 2 days
                // -> so the resa is not active anymore
                if (deltaInMilliseconds > 172800000) {
                    // 1 : update status reservation "active" to "false" => next person on the list
                    updateReservationStatusToFalse(reservation.getId());
                    // 2 : start all over to be sure that the next person on the list will be called
                    getListReservationWithEmailAndBook();
                } else {
                    finalList.add(reservation);
                }
            }
        }
        return finalList;
    }


    @Override
    public void borrowBook (User user, Book book) { getDaoFactory().getBookBorrowedDao().borrowBook(user, book); }

    @Override
    public void reserveBook (User user, Book book) { getDaoFactory().getBookReservedDao().reserveBook(user, book); }

    @Override
    public void extendBorrow(Integer id) {getDaoFactory().getBookBorrowedDao().extendBorrow(id);}

    @Override
    public void updateEmailStatus(Integer id) {getDaoFactory().getBookDao().updateEmailStatus(id);}

    @Override
    public void updateReservationStatusToFalse(Integer id) {getDaoFactory().getBookDao().updateReservationStatusToFalse(id);}

    @Override
    public Book getBook(Integer pId) { return getDaoFactory().getBookDao().read(pId); }

    @Override
    public ReservationWithEmail getOldestUserReservationForABook(Integer id) { return getDaoFactory().getBookDao().getOldestUserReservationForABook(id);}


    @Override
    public int getNbOfCopiesAvailableForABookBorrowed(BookBorrowed bookBorrowed) {
        int a;
        int b;
        int c;
        a = bookBorrowed.getNumberOfCopies();
        b = bookBorrowed.getNbOfCopiesAlreadyBorrowed();
        c = a - b;
        return c;
    }

    @Override
    public int getNbOfCopiesAvailableForABook(Book book) {
        int a;
        int b;
        int c;
        a = book.getNumberOfCopies();
        b = book.getNbOfCopiesAlreadyBorrowed();
        c = a - b;
        return c;
    }
}
