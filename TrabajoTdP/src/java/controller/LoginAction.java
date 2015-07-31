package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
        // create a new LoginBean with valid users in it
        LoginBean lb = new LoginBean();
        HttpSession session = request.getSession();

        // check to see if this user/password combination are valid
        if (lb.validateUser(((LoginForm) form).getUserName(), ((LoginForm) form).getPassword())) {
            request.setAttribute("userName", ((LoginForm) form).getUserName());
            session.setAttribute("logueado", true);
            return (mapping.findForward("exito"));
        } else // username/password not validated
        {
            // create ActionError and save in the request
            ActionErrors errors = new ActionErrors();
            ActionMessage error = new ActionMessage("error.login.invalid");
            errors.add("login", error);
            saveErrors(request, errors);
            session.setAttribute("logueado", false);
            return (mapping.findForward("falla"));
        }
    }

}
