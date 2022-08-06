package com.eric.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello");
        // this.getInitParameter(); 初始化参数
        // this.getServletConfig(); 配置
        // this.getServletContext(); 上下文
        // this.getServletName();
        // this.getInitParameter();
        // web容器启动时 创建一个对应的ServletContext对象,代表当前的web应用
        // 不同的Servlet之间进行共享数据/数据传输
        ServletContext servletContext = this.getServletContext();
        String username = "Eric";
        // 保存数据
        servletContext.setAttribute("username",username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
