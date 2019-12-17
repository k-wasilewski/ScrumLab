package pl.coderslab.web;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.get(email);
        if (admin != null) {
            if (BCrypt.checkpw(request.getParameter("password"), admin.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                getServletContext().getRequestDispatcher("/index").forward(request, response);
            } else {
                request.setAttribute("loginError", "Niewłaściwe dane logowania.");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("loginError", "Niewłaściwe dane logowania.");
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
