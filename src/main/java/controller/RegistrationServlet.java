package controller;

import org.mindrot.jbcrypt.BCrypt;
import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            if (email != null) {
                BCrypt.hashpw(password, BCrypt.gensalt());
                DBUtils.second("INSERT INTO users (email, password) VALUES (?, ?)",
                        new String[]{email, BCrypt.hashpw(password, BCrypt.gensalt())});
                response.sendRedirect("auth.jsp");
            }
        } catch (SQLException e) {
            System.out.println("exception: " + e.getMessage() + "/ email: " + email);
            e.printStackTrace();
        }
    }
}
