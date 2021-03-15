package controller;

import utils.DBUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CourseEnrollServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String course = request.getParameter("courseName");
        String userid = (String) request.getSession(false).getAttribute("userid");
        try {
            DBUtils.second("UPDATE users SET course_name = ? WHERE email = ?", new String[]{course, userid});
            response.sendRedirect("profile.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
