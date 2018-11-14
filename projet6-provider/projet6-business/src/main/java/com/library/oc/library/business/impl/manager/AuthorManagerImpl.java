package com.library.oc.library.business.impl.manager;

import java.util.List;
import javax.inject.Named;

import com.library.oc.library.business.contract.manager.AuthorManager;
import com.library.oc.library.business.contract.manager.UserManager;
import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.exception.NotFoundException;

@Named
public class AuthorManagerImpl extends AbstractManager implements  AuthorManager{

    @Override
    public Author getAuthor(Integer pId) throws NotFoundException {
        return getDaoFactory().getAuthorDao().read(pId);
    }

    @Override
    public List<Author> getListAuthor() {
        return getDaoFactory().getAuthorDao().readAll();
    }


}
