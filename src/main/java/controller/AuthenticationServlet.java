package controller;

import org.mindrot.jbcrypt.BCrypt;
import utils.DBUtils;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>");
        writer.println("You at auth page. Please navigate to auth.jsp");
        writer.println("</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            ResultSet userSet = DBUtils.get(
                    "SELECT * FROM users WHERE email = '" + email + "';"
            );
            if (userSet != null) {
                if (userSet.next()) {
                    if (!BCrypt.checkpw(password, userSet.getString("password"))) {
                        PrintWriter writer = response.getWriter();
                        writer.println("wrong password");
                    } else {
                        HttpSession session = request.getSession(false);
                        session.setAttribute("userid", String.valueOf(userSet.getInt("id")));
                        response.sendRedirect("profile.jsp");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }
    }
}
