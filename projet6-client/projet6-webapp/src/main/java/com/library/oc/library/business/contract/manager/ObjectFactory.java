
package com.library.oc.library.business.contract.manager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.library.oc.library.business.contract.manager package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAuthor_QNAME = new QName("http://manager.contract.business.library.oc.library.com/", "getAuthor");
    private final static QName _GetAuthorResponse_QNAME = new QName("http://manager.contract.business.library.oc.library.com/", "getAuthorResponse");
    private final static QName _GetListAuthor_QNAME = new QName("http://manager.contract.business.library.oc.library.com/", "getListAuthor");
    private final static QName _GetListAuthorResponse_QNAME = new QName("http://manager.contract.business.library.oc.library.com/", "getListAuthorResponse");
    private final static QName _NotFoundException_QNAME = new QName("http://manager.contract.business.library.oc.library.com/", "NotFoundException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.library.oc.library.business.contract.manager
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAuthor }
     * 
     */
    public GetAuthor createGetAuthor() {
        return new GetAuthor();
    }

    /**
     * Create an instance of {@link GetAuthorResponse }
     * 
     */
    public GetAuthorResponse createGetAuthorResponse() {
        return new GetAuthorResponse();
    }

    /**
     * Create an instance of {@link GetListAuthor }
     * 
     */
    public GetListAuthor createGetListAuthor() {
        return new GetListAuthor();
    }

    /**
     * Create an instance of {@link GetListAuthorResponse }
     * 
     */
    public GetListAuthorResponse createGetListAuthorResponse() {
        return new GetListAuthorResponse();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://manager.contract.business.library.oc.library.com/", name = "getAuthor")
    public JAXBElement<GetAuthor> createGetAuthor(GetAuthor value) {
        return new JAXBElement<GetAuthor>(_GetAuthor_QNAME, GetAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://manager.contract.business.library.oc.library.com/", name = "getAuthorResponse")
    public JAXBElement<GetAuthorResponse> createGetAuthorResponse(GetAuthorResponse value) {
        return new JAXBElement<GetAuthorResponse>(_GetAuthorResponse_QNAME, GetAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://manager.contract.business.library.oc.library.com/", name = "getListAuthor")
    public JAXBElement<GetListAuthor> createGetListAuthor(GetListAuthor value) {
        return new JAXBElement<GetListAuthor>(_GetListAuthor_QNAME, GetListAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://manager.contract.business.library.oc.library.com/", name = "getListAuthorResponse")
    public JAXBElement<GetListAuthorResponse> createGetListAuthorResponse(GetListAuthorResponse value) {
        return new JAXBElement<GetListAuthorResponse>(_GetListAuthorResponse_QNAME, GetListAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://manager.contract.business.library.oc.library.com/", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

}
