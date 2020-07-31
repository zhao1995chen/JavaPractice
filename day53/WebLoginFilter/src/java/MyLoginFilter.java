/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Zhao
 */
public class MyLoginFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String password = ((HttpServletRequest) request).getParameter("password");

        if (password != null && password.equals("opensesame")) {
            chain.doFilter(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>");
            out.println("Incorrect Password");
            out.println("</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");
            out.println("<H1>Incorrect Password</H1>");
            out.println("Sorry, that password was incorrect.");
            out.println("</BODY>");
            out.println("</HTML>");
        }
    }

    @Override
    public void destroy() {
    }
}
