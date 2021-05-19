package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/viewWords")
public class ViewWordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String languageId = request.getParameter("languageId");
        int intlanguageId = Integer.parseInt(languageId);
        String languageName = DictionaryData.getInstance().getLanguageById(intlanguageId).getName();
        request.setAttribute("words", DictionaryData.getInstance().getLanguageById(intlanguageId).getWords());
        request.setAttribute("name", languageName);
        getServletContext().getRequestDispatcher("/viewWords.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
