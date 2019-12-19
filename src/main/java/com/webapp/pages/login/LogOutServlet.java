package com.webapp.pages.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "Logout", urlPatterns = {"/logout"})
public class LogOutServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(com.webapp.pages.login.LogOutServlet.class);



    /**
     * Servlet container needs it.
     */
    @SuppressWarnings("unused")
    public LogOutServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logger.info("Got request with parameters " + req.getParameterMap());

        System.out.println(req.getRequestURI());
        req.getSession().removeAttribute("login");
        req.getSession().removeAttribute("account_type");
        req.getSession().removeAttribute("password");

        resp.sendRedirect(req.getContextPath() + "/index.html");





    }
}
