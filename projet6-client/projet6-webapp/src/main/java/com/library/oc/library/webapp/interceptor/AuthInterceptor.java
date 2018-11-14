package com.library.oc.library.webapp.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Interceptor permettant de vérifier qu'user est bien connecté et existe en session.
 * Si c'est le cas, on laisse passer la requête, sinon, on va partir sur un result, disant que l'action est interdite,
 * cette méthode renvoi un string qui est le result à utiliser par struts
 *
 */
public class AuthInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 7995153741671857846L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String vResult;
        // Si ma session contient un objet user, alors j'appelle l'interceptor
        // suivant dans la pile d'interceptor et renvoie son retour
        if (invocation.getInvocationContext().getSession().get("user") != null) {
            vResult = invocation.invoke();
            // si je n'ai pas d'user en session, on retourne un result (error-forbidden)
        } else {
            vResult = "error-forbidden";
        }
        return vResult;
    }
}
