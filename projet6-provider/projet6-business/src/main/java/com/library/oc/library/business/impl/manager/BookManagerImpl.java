package com.library.oc.library.business.impl.manager;

import java.util.List;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.model.bean.book.BookBorrowed;
import com.library.oc.library.model.bean.book.Book;
import com.library.oc.library.model.bean.user.User;

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
    public void borrowBook (User user, Book book) { getDaoFactory().getBookBorrowedDao().borrowBook(user, book); }

    @Override
    public void extendBorrow(Integer id) {getDaoFactory().getBookBorrowedDao().extendBorrow(id);}

    @Override
    public Book getBook(Integer pId) { return getDaoFactory().getBookDao().read(pId); }


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
