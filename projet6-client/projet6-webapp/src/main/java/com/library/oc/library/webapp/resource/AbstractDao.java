package com.library.oc.library.webapp.resource;


import com.library.oc.library.business.contract.manager.AuthorClient;
import com.library.oc.library.business.contract.manager.AuthorService;

public class AbstractDao {

    private AuthorService authorService = new AuthorService();
    private AuthorClient authorClient = authorService.getAuthorPort();

    public AuthorService getAuthorService() {
        return authorService;
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public AuthorClient getAuthorClient() {
        return authorClient;
    }

    public void setAuthorClient(AuthorClient authorClient) {
        this.authorClient = authorClient;
    }
}
