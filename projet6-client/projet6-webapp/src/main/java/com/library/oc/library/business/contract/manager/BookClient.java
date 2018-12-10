package com.library.oc.library.business.contract.manager;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-12-10T02:30:00.854+01:00
 * Generated source version: 3.2.5
 *
 */
@WebService(targetNamespace = "http://manager.contract.business.library.oc.library.com/", name = "BookClient")
@XmlSeeAlso({ObjectFactory.class})
public interface BookClient {

    @WebMethod
    @RequestWrapper(localName = "updateReservationStatusToFalse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.UpdateReservationStatusToFalse")
    @ResponseWrapper(localName = "updateReservationStatusToFalseResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.UpdateReservationStatusToFalseResponse")
    public void updateReservationStatusToFalse(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Integer id
    );

    @WebMethod
    @RequestWrapper(localName = "getBook", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetBook")
    @ResponseWrapper(localName = "getBookResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetBookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.library.oc.library.business.contract.manager.Book getBook(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Integer id
    );

    @WebMethod
    @RequestWrapper(localName = "getNbOfCopiesAvailableForABookBorrowed", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetNbOfCopiesAvailableForABookBorrowed")
    @ResponseWrapper(localName = "getNbOfCopiesAvailableForABookBorrowedResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetNbOfCopiesAvailableForABookBorrowedResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int getNbOfCopiesAvailableForABookBorrowed(
        @WebParam(name = "bookBorrowed", targetNamespace = "")
        com.library.oc.library.business.contract.manager.BookBorrowed bookBorrowed
    );

    @WebMethod
    @RequestWrapper(localName = "buildBookBorrowedDependencies", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.BuildBookBorrowedDependencies")
    @ResponseWrapper(localName = "buildBookBorrowedDependenciesResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.BuildBookBorrowedDependenciesResponse")
    public void buildBookBorrowedDependencies(
        @WebParam(name = "borrowedBook", targetNamespace = "")
        com.library.oc.library.business.contract.manager.BookBorrowed borrowedBook
    );

    @WebMethod
    @RequestWrapper(localName = "getNbOfCopiesAvailableForABook", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetNbOfCopiesAvailableForABook")
    @ResponseWrapper(localName = "getNbOfCopiesAvailableForABookResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetNbOfCopiesAvailableForABookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int getNbOfCopiesAvailableForABook(
        @WebParam(name = "book", targetNamespace = "")
        com.library.oc.library.business.contract.manager.Book book
    );

    @WebMethod
    @RequestWrapper(localName = "buildBookDependencies", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.BuildBookDependencies")
    @ResponseWrapper(localName = "buildBookDependenciesResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.BuildBookDependenciesResponse")
    public void buildBookDependencies(
        @WebParam(name = "book", targetNamespace = "")
        com.library.oc.library.business.contract.manager.Book book
    );

    @WebMethod
    @RequestWrapper(localName = "updateEmailStatus", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.UpdateEmailStatus")
    @ResponseWrapper(localName = "updateEmailStatusResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.UpdateEmailStatusResponse")
    public void updateEmailStatus(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Integer id
    );

    @WebMethod
    @RequestWrapper(localName = "borrowBook", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.BorrowBook")
    @ResponseWrapper(localName = "borrowBookResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.BorrowBookResponse")
    public void borrowBook(
        @WebParam(name = "user", targetNamespace = "")
        com.library.oc.library.business.contract.manager.User user,
        @WebParam(name = "book", targetNamespace = "")
        com.library.oc.library.business.contract.manager.Book book
    );

    @WebMethod
    @RequestWrapper(localName = "getListReservationWithEmailAndBook", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetListReservationWithEmailAndBook")
    @ResponseWrapper(localName = "getListReservationWithEmailAndBookResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetListReservationWithEmailAndBookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.library.oc.library.business.contract.manager.ReservationWithEmail> getListReservationWithEmailAndBook();

    @WebMethod
    @RequestWrapper(localName = "displayAllBooks", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.DisplayAllBooks")
    @ResponseWrapper(localName = "displayAllBooksResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.DisplayAllBooksResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.library.oc.library.business.contract.manager.Book> displayAllBooks();

    @WebMethod
    @RequestWrapper(localName = "reserveBook", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.ReserveBook")
    @ResponseWrapper(localName = "reserveBookResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.ReserveBookResponse")
    public void reserveBook(
        @WebParam(name = "user", targetNamespace = "")
        com.library.oc.library.business.contract.manager.User user,
        @WebParam(name = "book", targetNamespace = "")
        com.library.oc.library.business.contract.manager.Book book
    );

    @WebMethod
    @RequestWrapper(localName = "getListBookBorrowedByUser", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetListBookBorrowedByUser")
    @ResponseWrapper(localName = "getListBookBorrowedByUserResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetListBookBorrowedByUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.library.oc.library.business.contract.manager.BookBorrowed> getListBookBorrowedByUser(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Integer id
    );

    @WebMethod
    @RequestWrapper(localName = "getOldestUserReservationForABook", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetOldestUserReservationForABook")
    @ResponseWrapper(localName = "getOldestUserReservationForABookResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.GetOldestUserReservationForABookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.library.oc.library.business.contract.manager.ReservationWithEmail getOldestUserReservationForABook(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Integer id
    );

    @WebMethod
    @RequestWrapper(localName = "extendBorrow", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.ExtendBorrow")
    @ResponseWrapper(localName = "extendBorrowResponse", targetNamespace = "http://manager.contract.business.library.oc.library.com/", className = "com.library.oc.library.business.contract.manager.ExtendBorrowResponse")
    public void extendBorrow(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.Integer id
    );
}
