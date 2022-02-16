/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filter;

import com.mycompany.pojo.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoang
 */
@WebFilter(urlPatterns = {"/faces/product.xhtml"})
public class UserFilter implements Filter {

    private HttpServletRequest httpServletRequest;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        User u = (User) session.getAttribute("user");
        if (u != null) {
            if (!u.getU_role().equals("ADMIN")) {
                String home = "/faces/index.xhtml";
                RequestDispatcher dipDispatcher = httpServletRequest.getRequestDispatcher(home);
                dipDispatcher.forward(request, response);

            }else{
                chain.doFilter(request, response);//Cho vào
            }
        } else {
            String loginPage = "/faces/login.xhtml";
            RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
