package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delrecipe")
public class DelRecipeServlet extends HttpServlet {
    private int recipeId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id")!=null) recipeId = Integer.parseInt(request.getParameter("id"));

        if (request.getParameter("del")!=null && request.getParameter("del").equals("true")) {
            RecipePlanDao rpdao = new RecipePlanDao();
            rpdao.delete(recipeId);
            RecipeDao rdao = new RecipeDao();
            rdao.delete(recipeId);
            getServletContext().getRequestDispatcher("/app/recipe/list/").forward(request, response);
        } else getServletContext().getRequestDispatcher("/recipe-delete-confirmation-popup.jsp").forward(request, response);
    }
}
