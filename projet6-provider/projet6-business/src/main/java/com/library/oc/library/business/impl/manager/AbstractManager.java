package com.library.oc.library.business.impl.manager;


import com.library.oc.consumer.contract.DaoFactory;


public abstract class AbstractManager {

    //-- Variable d'instances
    private static DaoFactory daoFactory;

    //-- GETTER
    protected static DaoFactory getDaoFactory() {
        return daoFactory;
    }

    //-- SETTER
    public static void setDaoFactory(DaoFactory pDaoFactory) {
        daoFactory = pDaoFactory;
    }


}
