package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/DeleteWord")
public class DeleteWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lanIdStr = request.getParameter("languageId");
        String wordIdStr = request.getParameter("wordId");
        System.out.println(lanIdStr);
        System.out.println(wordIdStr);
        int lanId = Integer.parseInt(lanIdStr);
        int wordId = Integer.parseInt(wordIdStr);
        Language lanToDel = DictionaryData.getInstance().getLanguageById(lanId);
        DictionaryData.getInstance().deleteWord(lanToDel, wordId);
        response.sendRedirect("EditWords?languageId="+lanIdStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
