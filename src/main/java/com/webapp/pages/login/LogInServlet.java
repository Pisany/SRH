package com.webapp.pages.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LogInServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(LogInServlet.class);


    private LogService loginService;

    /**
     * Servlet container needs it.
     */
    @SuppressWarnings("unused")
    public LogInServlet() {
        this(new LogService());
    }

    LogInServlet(LogService loginService) {
        this.loginService = loginService;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logger.info("Got request with parameters " + req.getParameterMap());

        if (loginService.checkPassword(req)) {
            resp.getWriter().println("GIT");
            loginService.loginUtils.insertIntoUSERINFO(req);
            System.out.println(changePage());
            resp.sendRedirect(req.getContextPath() + changePage());


        } else {
            resp.getWriter().println("nie GIT");
            loginService.loginUtils.insertIntoLOGINATTEMPT(req);
        }
    }

    private String changePage() {
        if (loginService.checkAccType() == 0) {
            return "/app/admin/main/page.html";
        } else if (loginService.checkAccType() == 1) {
            return "/app/user/main/page.html";
        } else {
            return "error";
        }
    }


}
