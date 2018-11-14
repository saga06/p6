package com.library.oc.library.webservices.resource;

import com.library.oc.library.business.contract.ManagerFactory;

public abstract class AbstractResource {

	//-- Variable d'instances
    private static ManagerFactory managerFactory;

    //-- GETTER
    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    
    //-- SETTER
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}