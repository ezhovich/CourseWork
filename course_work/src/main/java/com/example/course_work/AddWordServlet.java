package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/AddWord")
public class AddWordServlet extends HttpServlet {

    public static final String EMPTY_NAME_ERROR_MESSAGE = "Word name can't be empty.";
    public static final String NON_UNIQUE_NAME_ERROR_MESSAGE = "Word already exists";
    public static final String ERROR_PARAMETER_NAME = "error=";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String wordToAdd = request.getParameter("word");
        String lanIdStr = request.getParameter("languageId");
        System.out.println(lanIdStr);
        int lanId = Integer.parseInt(lanIdStr);

        if (wordToAdd == null || wordToAdd.isEmpty()) {
            response.sendRedirect("EditWords?" +
                    ERROR_PARAMETER_NAME +
                    EMPTY_NAME_ERROR_MESSAGE);
        } else if (DictionaryData.getInstance().hasWord(lanId, wordToAdd)) {
            response.sendRedirect("EditWords?" +
                    ERROR_PARAMETER_NAME +
                    NON_UNIQUE_NAME_ERROR_MESSAGE);
        } else {
            DictionaryData.getInstance().addWord(wordToAdd, lanId);
            response.sendRedirect("EditWords?languageId="+lanIdStr);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
