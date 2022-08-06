package com.eric.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class ServletDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 路径
        String path = "D:\\java项目\\web开发\\maven_project2\\lab2_servlet\\servlet-02\\src\\main\\resources\\tw.png";
        // 下载的文件名
        String name = path.substring(path.lastIndexOf("\\")+1);
        // 让浏览器支持下载 中文编码
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(name,"UTF-8"));
        // 文件输入流
        FileInputStream in = new FileInputStream(path);
        // 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[2048];
        // 获取outputstream
        ServletOutputStream out = resp.getOutputStream();
        // 读入缓冲区 再输出到客户端
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        // shut down stream
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
