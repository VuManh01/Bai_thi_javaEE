<%@ page import="java.util.*,model.*,dao.*,util.*,java.sql.*" %>
<%
  List<Student> students = (List<Student>) request.getAttribute("students");
  ScoreDAO scoreDAO = new ScoreDAO();
  Connection conn = util.DBConnection.getConnection();
  Statement stmt = conn.createStatement();
  ResultSet rs = stmt.executeQuery(
          "SELECT s.student_id, s.student_code, s.full_name, sub.subject_name, " +
                  "ss.score1, ss.score2, sub.credit " +
                  "FROM student_score_t ss " +
                  "JOIN student_t s ON ss.student_id = s.student_id " +
                  "JOIN subject_t sub ON ss.subject_id = sub.subject_id"
  );
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Student Information System</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .table thead th {
      background-color: #3f613f;
      color: white;
      text-align: center;
    }
    .table td, .table th {
      vertical-align: middle;
      text-align: center;
    }
    .title-bar {
      background-color: #3f613f;
      color: white;
      padding: 10px;
      font-weight: bold;
      font-size: 20px;
    }
    .btn-group {
      margin: 15px 0;
    }
  </style>
</head>
<body class="container py-4">
<div class="title-bar text-center">Student Information System</div>

<h2 class="text-center mt-3">Student Information</h2>

<div class="d-flex justify-content-center btn-group">
  <a href="add_student.jsp" class="btn btn-success me-2">+ Student</a>
  <a href="add_score.jsp" class="btn btn-success">+ Score</a>
</div>

<table class="table table-bordered table-hover">
  <thead>
  <tr>
    <th>Id</th>
    <th>Student Id</th>
    <th>Student Name</th>
    <th>Subject Name</th>
    <th>Score 1</th>
    <th>Score 2</th>
    <th>Credit</th>
    <th>Grade</th>
    <th>Edit</th>
  </tr>
  </thead>
  <tbody>
  <%
    int id = 1;
    while(rs.next()) {
      double score1 = rs.getDouble("score1");
      double score2 = rs.getDouble("score2");
      double grade = 0.3 * score1 + 0.7 * score2;
      String gradeChar = "F";
      if (grade >= 8.0) gradeChar = "A";
      else if (grade >= 6.0) gradeChar = "B";
      else if (grade >= 4.0) gradeChar = "D";
  %>
  <tr>
    <td><%= id++ %></td>
    <td><%= rs.getString("student_code") %></td>
    <td><%= rs.getString("full_name") %></td>
    <td><%= rs.getString("subject_name") %></td>
    <td><%= score1 %></td>
    <td><%= score2 %></td>
    <td><%= rs.getInt("credit") %></td>
    <td><%= gradeChar %></td>
    <td><a href="editStudent?id=<%= rs.getInt("student_id") %>"><img src="https://cdn-icons-png.flaticon.com/512/1159/1159633.png" width="16" height="16"></a></td>
  </tr>
  <%
    }
    rs.close();
    stmt.close();
    conn.close();
  %>
  </tbody>
</table>
</body>
</html>
