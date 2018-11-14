package com.library.oc.library.business.contract.manager;

import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;


/**
 * Manager du package « user »
 */
@WebService(name="UserClient", serviceName="UserService",portName = "UserPort")
public interface UserManager {

    /**
     * Renvoie la liste des {@link User}
     *
     * @return List
     * @param pId
     */
    List<User> getListUser(@WebParam(name = "id") Object pId);

    /**
     * Renvoie  l'objet User ciblé.
     * @param pId l'identifiant de l'User
     * @return Un objet User.
     * @throws NotFoundException
     */
    User getUser(@WebParam(name = "id") Integer pId) throws NotFoundException;


    /**
     * Retourne le nombre de User dans la base de données.
     * @return Le nombre de user en base de données
     */
    Integer getNbUser();

    List<User> getListUserLateReturn();

    String hashPassword(@WebParam(name = "password") String password);
    User getEmailUser(@WebParam(name = "username") String username);

    boolean validateLogin(@WebParam(name = "user") User user,
                          @WebParam(name = "password") String password);}