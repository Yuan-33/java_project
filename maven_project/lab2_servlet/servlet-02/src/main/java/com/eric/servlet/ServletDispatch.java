package com.eric.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDispatch extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入ServletDispatch");
        ServletContext servletContext = this.getServletContext();
        // 转发的请求路径
        // 不是重定向
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/geturl");
        // 调用forward请求转发
        requestDispatcher.forward(req,resp);
        // servletContext.getRequestDispatcher("/geturl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
