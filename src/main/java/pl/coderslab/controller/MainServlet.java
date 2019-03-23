package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numbersSolution = getServletContext().getInitParameter("number-solutions");

        List<Solution> recentSolutions = SolutionDAO.findRecent(Integer.valueOf(numbersSolution));

        req.setAttribute("recentSolutions", recentSolutions);

        getServletContext()
            .getRequestDispatcher("/index.jsp")
            .forward(req, resp);
    }
}
