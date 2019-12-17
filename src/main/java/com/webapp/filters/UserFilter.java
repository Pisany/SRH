package com.webapp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/app/usr/*")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig config)
            throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);



        if (session == null || session.getAttribute("accType") == null || !session.getAttribute("accType").toString().equals("1")) { // change "user" for the session attribute you have defined
            System.out.println("access denied usr");
            System.out.println(request.getContextPath());
            response.sendRedirect((request.getContextPath()+"/app/admin/main.html")); // No logged-in user found, so redirect to login page.

        } else {
            chain.doFilter(req, res); // Logged-in user found, so just continue request.
            System.out.println("access available usr");
        }
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }

    //basic validation of pages that do not require authentication
    private boolean needsAuthentication(String url) {
        String[] validNonAuthenticationUrls =
                { "index.html" };
        for(String validUrl : validNonAuthenticationUrls) {
            if (url.endsWith(validUrl)) {
                return false;
            }
        }
        return true;
    }
}
