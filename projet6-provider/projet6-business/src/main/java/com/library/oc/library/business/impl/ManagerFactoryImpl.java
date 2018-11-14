package com.library.oc.library.business.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.business.contract.manager.AuthorManager;
import com.library.oc.library.business.contract.manager.BookManager;
import com.library.oc.library.business.contract.manager.UserManager;


/**
 * Implémentation de la {@link ManagerFactory}.
 */
//Bean pouvant être injecté grâce à @Named
@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private BookManager bookManager;
    @Override
    public BookManager getBookManager() {
        return bookManager;
    }
    public void setBookManager(BookManager pBookManager) {
        bookManager = pBookManager;
    }

    @Inject
    private UserManager userManager;
    @Override
    public UserManager getUserManager() {
        return userManager;
    }
    public void setUserManager(UserManager pUserManager) {
        userManager = pUserManager;
    }

    @Inject
    private AuthorManager authorManager;
    @Override
    public AuthorManager getAuthorManager() { return authorManager; }
    @Override
    public void setAuthorManager(AuthorManager pAuthorManager) { authorManager = pAuthorManager;}


}
