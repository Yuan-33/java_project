package com.eric.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ServletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            out.write("你上一次访问的时间是:");
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("time")){
                    long time = Long.parseLong(cookie.getValue());
                    Date date = new Date(time);
                    out.write(date.toString());
                }
            }
        }
        else{
            out.write("这是您第一次访问该网站");
        }
        Cookie cookie = new Cookie("time", System.currentTimeMillis()+"");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
