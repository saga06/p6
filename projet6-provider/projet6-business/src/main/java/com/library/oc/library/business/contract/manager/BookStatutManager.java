package com.library.oc.library.business.contract.manager;

import java.util.List;

import com.library.oc.library.model.bean.book.BookStatut;
import com.library.oc.library.model.exception.NotFoundException;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="BookStatutService", serviceName="BookStatutService")
public interface BookStatutManager {

    /**
     * Retourne le book ciblé.
     * @param pId
     * @return
     * @throws NotFoundException
     */
    BookStatut getBookStatut(@WebParam(name = "id") Integer pId) throws NotFoundException;

    /**
     * Retourne la liste des book en base de données.
     *
     * @return La liste des objets Book présents en base de données
     */
    List<BookStatut> getListBookStatut();

    /**
     * Détermine le nombre de book en base de données.
     *
     * @return Le nombre de book en base de données (Entier)
     */
    int getNbBookStatut();
}
