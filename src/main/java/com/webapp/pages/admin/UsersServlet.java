package com.webapp.pages.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Users", urlPatterns = {"/users/*"})
public class UsersServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(UsersServlet.class);


    private UsersService usersService;

    /**
     * Servlet container needs it.
     */
    @SuppressWarnings("unused")
    public UsersServlet() {
        this(new UsersService());
    }

    UsersServlet(UsersService usersService) {
        this.usersService = usersService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().println("GIT");
        resp.sendRedirect(req.getContextPath() + "/app/admin/users/page.html");

    }


}
