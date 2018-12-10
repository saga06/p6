package com.library.oc.library.webapp.action;




import com.library.oc.library.business.contract.manager.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Action de gestion de la connexion/déconnexion d'un user
 */

public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware {


    private User user;
    private String email;

    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private String login;
    private String password;

    // ----- Eléments Struts
    private Map<String,Object> session;
    private HttpServletRequest servletRequest;

    private UserService userService = new UserService();
    private UserClient userClient = userService.getUserPort();

    private BookService bookService = new BookService();
    private BookClient bookClient = bookService.getBookPort();


    // ==================== Getters/Setters ====================
    public String getEmail() {
        return email;
    }
    public void setEmail(String pEmail) {
        email = pEmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pPassword) {
        password = pPassword;
    }
    public User getUser() { return user; }


    // ==================== Méthodes ====================

    /**
     * Action permettant la connexion d'un user
     * @return input / success
     */

    public String doLogin()  {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(email,password)) {
            user = userClient.getEmailUser(this.email);



            if (user != null && userClient.validateLogin(user, this.password))
            {
/*
                List <BookBorrowed> booksBorrowed = bookClient.getListBookBorrowedByUser(user.getId());
*/

                // Ajout de l'user en session
                this.session.put("user", getUser());
                // Ajout des livres déjà empruntés en sessions:
                /*this.session.put(("listBookBorrowed"),booksBorrowed);*/

                vResult = ActionSupport.SUCCESS;
            }
            else {
                this.addFieldError("login.name","Identifiant ou mot de passe invalide !");
            }
        }
        return vResult;
    }


    /** Action de déconnexion d'un user
     * @return success
     */


    public String doLogout() {
        // Suppression de l'user en session
        this.servletRequest.getSession().invalidate();
        //this.session.remove("user");
        return ActionSupport.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;

    }

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }

}
