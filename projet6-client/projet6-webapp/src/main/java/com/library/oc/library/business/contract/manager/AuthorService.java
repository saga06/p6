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
 * 2018-12-11T17:51:07.560+01:00
 * Generated source version: 3.2.5
 *
 */
@WebServiceClient(name = "AuthorService",
                  wsdlLocation = "http://localhost:8080/services/AuthorService?wsdl",
                  targetNamespace = "http://manager.contract.business.library.oc.library.com/")
public class AuthorService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://manager.contract.business.library.oc.library.com/", "AuthorService");
    public final static QName AuthorPort = new QName("http://manager.contract.business.library.oc.library.com/", "AuthorPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/services/AuthorService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AuthorService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/services/AuthorService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AuthorService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AuthorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuthorService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public AuthorService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public AuthorService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public AuthorService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns AuthorClient
     */
    @WebEndpoint(name = "AuthorPort")
    public AuthorClient getAuthorPort() {
        return super.getPort(AuthorPort, AuthorClient.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuthorClient
     */
    @WebEndpoint(name = "AuthorPort")
    public AuthorClient getAuthorPort(WebServiceFeature... features) {
        return super.getPort(AuthorPort, AuthorClient.class, features);
    }

}
