package controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginForm extends ActionForm {

    private String userName;
    private String password;
    
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        password = "";
        userName = "";
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if ((userName == null) || (userName.length() < 1)) {
            errors.add("userName", new ActionMessage("error.username.required"));
        }
        if ((password == null) || (password.length() < 1)) {
            errors.add("password", new ActionMessage("error.password.required"));
        }

        return errors;

    }

    public String getPassword() {
        return password;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setPassword(String string) {
        password = string;
    }

    public void setUserName(String string) {
        userName = string;
    }

}
