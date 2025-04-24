package servlet;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));
        
        try {
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.deleteStudent(studentId);
            response.sendRedirect("studentInfo");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Error deleting student", e);
        }
    }
}