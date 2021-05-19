package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/translateWord")
public class TranslateWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String wordToTranslate = request.getParameter("word");
        Integer languageFrom = Integer.parseInt(request.getParameter("fromLanguage"));
        Integer languageTo = Integer.parseInt(request.getParameter("toLanguage"));
        String languageFromStr = languageFrom.toString();
        String languageToStr = languageTo.toString();

        String res = DictionaryData.getInstance().translateWord(wordToTranslate, languageFrom, languageTo);
        request.setAttribute("translation", res);
        getServletContext().getRequestDispatcher("/viewTranslations?word="+wordToTranslate+"&fromLanguage="+languageFromStr+"&toLanguage="+languageToStr).forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
