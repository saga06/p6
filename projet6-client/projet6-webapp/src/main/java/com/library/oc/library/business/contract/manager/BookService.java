package com.library.oc.library.business.contract.manager;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-12-18T22:42:10.995+01:00
 * Generated source version: 3.2.5
 *
 */
@WebServiceClient(name = "BookService",
                  wsdlLocation = "http://localhost:8080/services/BookService?wsdl",
                  targetNamespace = "http://manager.contract.business.library.oc.library.com/")
public class BookService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://manager.contract.business.library.oc.library.com/", "BookService");
    public final static QName BookPort = new QName("http://manager.contract.business.library.oc.library.com/", "BookPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/services/BookService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(BookService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/services/BookService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public BookService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BookService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BookService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public BookService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public BookService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public BookService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns BookClient
     */
    @WebEndpoint(name = "BookPort")
    public BookClient getBookPort() {
        return super.getPort(BookPort, BookClient.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BookClient
     */
    @WebEndpoint(name = "BookPort")
    public BookClient getBookPort(WebServiceFeature... features) {
        return super.getPort(BookPort, BookClient.class, features);
    }

}
