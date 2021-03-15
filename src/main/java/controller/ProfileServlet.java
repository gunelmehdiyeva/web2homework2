package controller;

import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstname = request.getParameter("firstname");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");

        try {
            DBUtils.second("UPDATE users SET firstname = ?, surname = ?, age = ?, country = ?,  gender = ?" +
                    " WHERE id = ? ",
                    new String[]{firstname, surname, age, country, gender, (String) request.getSession().getAttribute("userid")});
            response.sendRedirect("profile.jsp");
        } catch (SQLException e) {
            System.out.println("you have a problem");
            e.printStackTrace();
        }
    }
}
