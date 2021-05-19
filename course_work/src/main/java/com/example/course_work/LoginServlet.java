package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        request.setAttribute("valid", "0");
        if(login.equals("admin") && password.equals("admin")){
            request.setAttribute("valid", "1");
            System.out.println("sheeesh");
            HttpSession session = request.getSession();
            session.setAttribute("login", 1);
            response.sendRedirect("EditLanguages");
        }


    }
}
