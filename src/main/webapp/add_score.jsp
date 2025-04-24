<%@ page import="dao.*,model.*,java.util.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%
    StudentDAO studentDAO = new StudentDAO();
    List<Student> students = studentDAO.getAllStudents();
    Connection conn = util.DBConnection.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet subjects = stmt.executeQuery("SELECT * FROM subject_t");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Score</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">
<h2 class="text-center mb-4">Add Score for Student</h2>

<form action="addScore" method="post" class="mx-auto" style="max-width: 500px;">
    <div class="mb-3">
        <label for="student_id" class="form-label">Select Student</label>
        <select class="form-select" name="student_id" id="student_id" required>
            <% for (Student s : students) { %>
            <option value="<%= s.getId() %>"><%= s.getCode() %> - <%= s.getFullName() %></option>
            <% } %>
        </select>
    </div>

    <div class="mb-3">
        <label for="subject_id" class="form-label">Select Subject</label>
        <select class="form-select" name="subject_id" id="subject_id" required>
            <% while (subjects.next()) { %>
            <option value="<%= subjects.getInt("subject_id") %>"><%= subjects.getString("subject_name") %></option>
            <% }
                subjects.close();
                stmt.close();
                conn.close();
            %>
        </select>
    </div>

    <div class="mb-3">
        <label for="score1" class="form-label">Score 1</label>
        <input type="number" id="score1" class="form-control" step="0.01" min="0" max="10" name="score1" required>
    </div>
    <div class="mb-3">
        <label for="score2" class="form-label">Score 2</label>
        <input type="number" id="score2" class="form-control" step="0.01" min="0" max="10" name="score2" required>
    </div>

    <div class="text-center">
        <button type="submit" class="btn btn-success">Add Score</button>
        <a href="studentInfo" class="btn btn-secondary ms-2">Cancel</a>
    </div>
</form>
</body>
</html>
