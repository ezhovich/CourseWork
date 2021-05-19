package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/DeleteLanguage")
public class DeleteLanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("lanId");
        int id = Integer.parseInt(idStr);
        Language lanToDel = DictionaryData.getInstance().getLanguageById(id);
        DictionaryData.getInstance().deleteLanguage(lanToDel);
        response.sendRedirect("EditLanguages");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
