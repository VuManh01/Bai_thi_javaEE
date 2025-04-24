package servlet;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        String studentCode = request.getParameter("student_code");
        String fullName = request.getParameter("full_name");
        String address = request.getParameter("address");

        Student student = new Student(studentId, studentCode, fullName, address);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.updateStudent(student);

        response.sendRedirect("studentInfo"); // Redirect back to the student info page after update
    }
}
