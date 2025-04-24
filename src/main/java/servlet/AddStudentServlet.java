package servlet;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.sql.SQLException;

// servlet/AddStudentServlet.java
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student();
        s.setCode(req.getParameter("code"));
        s.setFullName(req.getParameter("name"));
        s.setAddress(req.getParameter("address"));
        try {
            new StudentDAO().addStudent(s);
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("studentInfo");
    }
}
