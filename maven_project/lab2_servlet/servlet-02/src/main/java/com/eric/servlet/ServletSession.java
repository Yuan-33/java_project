package com.eric.servlet;

import com.eric.pojo.Product;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 得到Session
        HttpSession session = req.getSession();
        // 存东西
        session.setAttribute("name",new Product(10,20));
        // 获取ID
        String id = session.getId();
        // 判断是否是新创建的Session
        // 打开网页的时候就已经创建了Session
        if (session.isNew()){
            resp.getWriter().write("session创建成功,ID是:"+id);
        }
        else {
            resp.getWriter().write("session已经创建,ID是:"+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
