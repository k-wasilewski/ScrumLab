package pl.coderslab.web;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/register")
public class Register extends HttpServlet {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]{2,3}$";
    private static final String PASSWD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
        AdminDao adminDao = new AdminDao();

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        Pattern compiledPattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = compiledPattern.matcher(email);
        while (!matcher.matches()) {
            request.setAttribute("errorEmail", "Podaj właściwy adres email");
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }
        while (adminDao.doesExist(email)) {
            request.setAttribute("errorEmail", "Użytkownik o tym adresie e-mail już jest zarejestrowany.<a " +
                    "href=\"/login\"> Zaloguj&nbspsię</a>");
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }
        request.setAttribute("email", email);
        compiledPattern = Pattern.compile(PASSWD_REGEX);
        matcher = compiledPattern.matcher(request.getParameter("password"));
        while (!matcher.matches()) {
            request.setAttribute("errorPwd", "Hasło musi składać się z minimum 8 znaków, w tym jedenj wielkiej " +
                    "litery, jednej małej litery i jednej cyfry.");
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }

        while (!BCrypt.checkpw(request.getParameter("repassword"), password)) {
            request.setAttribute("errorPwd", "Podane hasła muszą się zgadzać");
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);

        }
        {

            Admin admin = new Admin();
            admin.setFirstName(firstName);
            admin.setLastName(lastName);
            admin.setEmail(email);
            admin.setPassword(password);
            admin = adminDao.create(admin);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
