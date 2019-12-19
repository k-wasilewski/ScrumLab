package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/recipe/list")
public class AppRecipesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDao rdao = new RecipeDao();
        List<Recipe> recipeList = rdao.findAllDesc();
        HttpSession sess = request.getSession();
        sess.setMaxInactiveInterval(3600);
        sess.setAttribute("recipeList", recipeList);
        if (request.getParameter("msg") != null) {
            getServletContext().getRequestDispatcher("/app-recipes.jsp?msg=true").forward(request, response);
        } else if (request.getParameter("failed") != null) {
            getServletContext().getRequestDispatcher("/app-recipes.jsp?failed=true").forward(request, response);

        } else {
            getServletContext().getRequestDispatcher("/app-recipes.jsp").forward(request, response);
        }
    }
}