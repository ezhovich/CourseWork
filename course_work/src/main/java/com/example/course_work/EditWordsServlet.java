package com.example.course_work;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/EditWords")
public class EditWordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String page = "/editWords.jsp";
        if(session.getAttribute("login")==null){
            page = "/index.jsp";
        }

        request.setAttribute("languages", DictionaryData.getInstance().getLanguages());
        int lanId = Integer.parseInt(request.getParameter("languageId"));
        request.setAttribute("words", DictionaryData.getInstance().getWordsByLanguageId(lanId));
        String languageName = DictionaryData.getInstance().getLanguageById(lanId).getName();
        request.setAttribute("name", languageName);
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
