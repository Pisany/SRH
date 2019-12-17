package com.webapp.pages.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/logout"})
public class LogOutServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(LogOutServlet.class);



//    private LoginService service;

    /**
     * Servlet container needs it.
     */
    @SuppressWarnings("unused")
//    public LoginServlet() {
//        this(new LoginService());
//    }

//    LoginServlet(LoginService service) {
//        this.service = service;
//    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        logger.info("Got request with parameters " + req.getParameterMap());



//        service.prepareUserList();
//        System.out.println("Servlet");
//        System.out.println(req.getRequestURI());
//        if(service.checkPassword(req)){
//
//            System.out.println(req.getSession().getAttribute("login"));
//            System.out.println("->" + req.getSession().getAttribute("account_type") + "<-");
//            System.out.println(req.getContextPath());
//
//
//            if(req.getSession().getAttribute("account_type").toString().equals("0")) {
//                System.out.println("option 1");
//                System.out.println(req.getContextPath());
//                resp.sendRedirect(req.getContextPath() + "/app/adm/main.jsp");
//
//            }else{
//                System.out.println("option 2");
//
//                resp.sendRedirect(req.getContextPath() + "/app/usr/main.jsp");
//
//            }
//
//        }else{
//            resp.sendRedirect(req.getContextPath() + "/wrongPassword.html");
//        }
//

    }
}
