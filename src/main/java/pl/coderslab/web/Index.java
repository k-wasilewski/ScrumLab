package pl.coderslab.web;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;
import pl.coderslab.dao.SuperAdminDao;
import pl.coderslab.model.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("")
public class Index extends HttpServlet {
    private Admin admin;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        sess.setMaxInactiveInterval(3600);
        RecipeDao rdao = new RecipeDao();
        Recipe absoluteLast=rdao.readAbsoluteLast();
        request.setAttribute("lastRecipe", absoluteLast);
        if (sess.getAttribute("admin")!=null) {
            admin = (Admin) sess.getAttribute("admin");
            getServletContext().getRequestDispatcher("/adminIndex.jsp").forward(request, response);
        } else getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
