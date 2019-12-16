package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/recipe/add")
public class AddRecipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String description=request.getParameter("description");
        int preparation_time;
        if (request.getParameter("preparation_time")!="") {
            preparation_time=Integer.parseInt(request.getParameter("preparation_time"));
        } else {
            preparation_time = 0;
        }
        String preparation=request.getParameter("preparation");
        String ingredients=request.getParameter("ingredients");

        Recipe newRecipe = new Recipe();
        newRecipe.setName(name);
        newRecipe.setDescription(description);
        newRecipe.setPreparation_time(preparation_time);
        newRecipe.setPreparation(preparation);
        newRecipe.setIngredients(ingredients);
        newRecipe.setAdmin_id(1);     //skad adminId ???

        RecipeDao rdao = new RecipeDao();
        rdao.create(newRecipe);

        getServletContext().getRequestDispatcher("/addrecipe.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addrecipe.jsp").forward(request, response);
    }
}
