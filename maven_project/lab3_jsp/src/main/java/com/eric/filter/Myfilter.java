package com.eric.filter;

import com.eric.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;

        if (request1.getSession().getAttribute(Constant.USER_SESSION)==null){
            response1.sendRedirect("/s1/error.jsp");
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
