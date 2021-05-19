package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/AddTranslation")
public class AddTranslationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String wordIdStr = request.getParameter("wordId");
        String lanIdStr = request.getParameter("languageId");
        String translationLanIdStr = request.getParameter("translationLanguage");
        String translatedWord = request.getParameter("translation");

        int wordId = Integer.parseInt(wordIdStr);
        int lanId = Integer.parseInt(lanIdStr);
        int translationLanId = Integer.parseInt(translationLanIdStr);

        DictionaryData.getInstance().addTranslation(lanId, wordId, translationLanId, translatedWord);
        response.sendRedirect("EditWords?languageId="+lanIdStr);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
