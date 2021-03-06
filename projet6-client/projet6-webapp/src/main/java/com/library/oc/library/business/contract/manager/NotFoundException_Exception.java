
package com.library.oc.library.business.contract.manager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-12-20T23:33:37.902+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "NotFoundException", targetNamespace = "http://manager.contract.business.library.oc.library.com/")
public class NotFoundException_Exception extends Exception {

    private com.library.oc.library.business.contract.manager.NotFoundException notFoundException;

    public NotFoundException_Exception() {
        super();
    }

    public NotFoundException_Exception(String message) {
        super(message);
    }

    public NotFoundException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public NotFoundException_Exception(String message, com.library.oc.library.business.contract.manager.NotFoundException notFoundException) {
        super(message);
        this.notFoundException = notFoundException;
    }

    public NotFoundException_Exception(String message, com.library.oc.library.business.contract.manager.NotFoundException notFoundException, java.lang.Throwable cause) {
        super(message, cause);
        this.notFoundException = notFoundException;
    }

    public com.library.oc.library.business.contract.manager.NotFoundException getFaultInfo() {
        return this.notFoundException;
    }
}
