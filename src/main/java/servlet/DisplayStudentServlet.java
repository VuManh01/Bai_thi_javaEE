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
import java.util.List;

// servlet/DisplayStudentServlet.java
@WebServlet("/studentInfo")
public class DisplayStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Student> students = new StudentDAO().getAllStudents();
            req.setAttribute("students", students);
        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }
        req.getRequestDispatcher("student_info.jsp").forward(req, resp);
    }
}
