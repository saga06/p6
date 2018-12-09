package com.library.oc.library.business.impl.manager;

import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.book.Reservation;
import com.library.oc.library.model.bean.book.ReservationWithEmail;
import com.library.oc.library.model.bean.user.User;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

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
        // Reservation active list (with active status)
        List<Reservation> reservationsActive = getDaoFactory().getBookDao().findAllActiveReservation();
        System.out.println("il y a " + reservationsActive.size() + " reservation(s) active(s)");
        // Reservation active list with available book initialisation
        List<Reservation> reservationsAvailable = new ArrayList<>();
        for(Reservation reservation : reservationsActive)
        {
            // we get the id of the book reserved
            int idBook = reservation.getIdBook();
            // we get the object book with the id (bc we need the objet for the method getNbOfCopie...)
            Book bookReserved = getDaoFactory().getBookDao().read(idBook);
            // we get the number of book available
            buildBookDependencies(bookReserved);

            Integer nbAvailable = bookReserved.getNbOfCopiesAvailable();

            if (nbAvailable > 0 ){
            System.out.println("il y a une réservation pour le livre " + bookReserved.getTitle() + " qui est disponible");}
            else { System.out.println("il n'y a pas d'exemplaire disponible de " + bookReserved.getTitle());}

            // if the book is available, we add the reservation in the list of reservationsAvailable
            if (nbAvailable > 0) {
                int idUser = reservation.getIdUser();
                reservationsAvailable.add(reservation);
                System.out.println("il y a une réservation qui peut etre honoree");
            }
        }
        // For each active reservation with newly available book, we are looking for the oldest reservation information:
        // user, user email, and id book
        List <ReservationWithEmail> finalList = new ArrayList<>();
        List<Integer> idsBook = new ArrayList<>();
        for (Reservation reservationsAvailableWithInfo : reservationsAvailable) {
            // we get the id of the reservation
            int idBook = reservationsAvailableWithInfo.getIdBook();
            // we use the superExtraGigaMethod to get ONLY the oldest reservation information
            ReservationWithEmail finalResa = getOldestUserReservationForABook(idBook);
            if (finalResa != null) {
                int idBook2 = finalResa.getIdBook();
                if (!idsBook.contains(idBook2)){
                    idsBook.add(idBook2);
                    finalList.add(finalResa);
                }
            }
        }
        System.out.println("il y a au total " + finalList.size() + " email(s) à envoyer");
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
