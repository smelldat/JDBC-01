package fr.wcs.jdbc.controller;

import fr.wcs.jdbc.model.LoadDriver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JdbcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoadDriver test = new LoadDriver();
        List<String> jedi = test.executerTests( request );
        request.setAttribute("jedi", jedi);
        request.getRequestDispatcher("/jdbc.jsp").forward(request, response);
    }
}
