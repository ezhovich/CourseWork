package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/AddLanguage")
public class AddLanguageServlet extends HttpServlet {

    public static final String EMPTY_NAME_ERROR_MESSAGE = "Language name can't be empty.";
    public static final String NON_UNIQUE_NAME_ERROR_MESSAGE = "Language already exists";
    public static final String ERROR_PARAMETER_NAME = "error=";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String languageName = request.getParameter("language");

        if (languageName == null || languageName.isEmpty()) {
            response.sendRedirect("EditLanguages?" +
                    ERROR_PARAMETER_NAME +
                    EMPTY_NAME_ERROR_MESSAGE);
        } else if (DictionaryData.getInstance().hasLanguage(languageName)) {
            response.sendRedirect("EditLanguages?" +
                    ERROR_PARAMETER_NAME +
                    NON_UNIQUE_NAME_ERROR_MESSAGE);
        } else {

            Language lan = new Language(languageName);
            DictionaryData.getInstance().addLanguage(lan);
            response.sendRedirect("EditLanguages");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
