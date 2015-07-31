package controller;

import java.util.HashMap;

public class LoginBean {

    private HashMap validUsers = new HashMap();

    public LoginBean() {
        validUsers.put("administrator", "admin");
    }

    public boolean validateUser(String userName, String password) {
        if (validUsers.containsKey(userName)) {
            String thePassword = (String) validUsers.get(userName);
            if (thePassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
