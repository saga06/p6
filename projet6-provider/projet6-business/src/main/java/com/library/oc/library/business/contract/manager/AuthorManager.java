package com.library.oc.library.business.contract.manager;

import com.library.oc.library.model.bean.book.Author;
import com.library.oc.library.model.exception.NotFoundException;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Manager du package « author »
 */
@WebService(name="AuthorClient", serviceName="AuthorService",portName = "AuthorPort")
public interface AuthorManager {
    /**
     * Renvoie l'auteur demandé
     *
     * @param pId l'identifiant de l'auteur
     * @return Le {@link Author}
     * @throws NotFoundException Si l'auteur n'est pas trouvé
     */
    Author getAuthor(@WebParam(name = "id") Integer pId) throws NotFoundException;
    /**
     * Renvoie la liste des {@link Author}
     * @return List
     */
    List<Author> getListAuthor();










}
