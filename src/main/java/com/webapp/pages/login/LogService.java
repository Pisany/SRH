package com.webapp.pages.login;

import com.webapp.DbUtils.LoginUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class LogService {
    private HttpServletRequest req;
    LoginUtils loginUtils;

    boolean checkPassword(HttpServletRequest req) {
        this.req = req;
        loginUtils = new LoginUtils();
        var loginParam = req.getParameter("login");
        var passwordParam = req.getParameter("password");

        if (loginParam.length() > 3 && passwordParam.length() > 5) {
            Map userMap = loginUtils.getSingleUser(loginParam);

            if (userMap.get("password") != null && userMap.get("password").equals(passwordParam)) {
                setAttribute(userMap);
                return true;
            }
        }
        return false;
    }

    private void setAttribute(Map userMap) {
        req.getSession().setAttribute("userID", userMap.get("userID"));
        req.getSession().setAttribute("accType", userMap.get("accType"));
        req.getSession().setAttribute("login", userMap.get("login"));
        req.getSession().setAttribute("password", userMap.get("password"));
    }

    int checkAccType() {
        var accType = req.getSession().getAttribute("accType");
        if (accType != null) {
            return Integer.parseInt(accType.toString());
        }
        return 100;
    }


}
