package dao;

import model.Student;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    public void addStudent(Student s) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO student_t (student_code, full_name, address) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, s.getCode());
        stmt.setString(2, s.getFullName());
        stmt.setString(3, s.getAddress());
        stmt.executeUpdate();
        conn.close();
    }

    public List<Student> getAllStudents() throws SQLException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student_t");
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("student_id"));
            s.setCode(rs.getString("student_code"));
            s.setFullName(rs.getString("full_name"));
            s.setAddress(rs.getString("address"));
            list.add(s);
        }
        conn.close();
        return list;
    }
    public void updateStudent(Student student) {
        String query = "UPDATE student_t SET student_code = ?, full_name = ?, address = ? WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, student.getCode());
            stmt.setString(2, student.getFullName());
            stmt.setString(3, student.getAddress());
            stmt.setInt(4, student.getId());

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int studentId) {
        Student student = null;
        String query = "SELECT * FROM student_t WHERE student_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, studentId); // Gán studentId vào câu truy vấn

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Tạo đối tượng Student từ dữ liệu trả về
                student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_code"),
                        rs.getString("full_name"),
                        rs.getString("address")
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

}