package com.library.oc.consumer.contract.dao;

import java.util.List;

import com.library.oc.library.model.bean.user.User;

public interface UserDao {

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    User read(int id);
    User read(String code);
    List<User> readAll();
    List<User> readAll(int id);

    /**
     * Retourne le nombre d'user
     * @param
     * @return Le nombre d'user
     */
    Integer getNbUser();

    /**
     * Recherche par email de l'user
     * @param
     * @return user
     */
    User findByEmail(String email);

    List<User> getListUserLateReturn();




}

