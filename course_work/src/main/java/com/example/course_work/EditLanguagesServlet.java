package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/EditLanguages")
public class EditLanguagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String page = "/editLanguages.jsp";
        if(session.getAttribute("login")==null){
            page = "/login.jsp";
        }

        request.setAttribute("languages", DictionaryData.getInstance().getLanguages());
        request.setAttribute("error",request.getParameter("error"));
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
