<%@ page import="model.Student, dao.StudentDAO" %>
<%
  Student student = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Edit Student</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">
<h2 class="text-center mb-4">Edit Student Information</h2>

<form action="updateStudent" method="post" class="mx-auto" style="max-width: 500px;">
  <div class="mb-3">
    <label for="student_code" class="form-label">Student Code</label>
    <input type="text" class="form-control" id="student_code" name="student_code" value="<%= student.getCode() %>" required>
  </div>
  <div class="mb-3">
    <label for="full_name" class="form-label">Full Name</label>
    <input type="text" class="form-control" id="full_name" name="full_name" value="<%= student.getFullName() %>" required>
  </div>
  <div class="mb-3">
    <label for="address" class="form-label">Address</label>
    <input type="text" class="form-control" id="address" name="address" value="<%= student.getAddress() %>">
  </div>

  <input type="hidden" name="student_id" value="<%= student.getId() %>">

  <div class="text-center">
    <button type="submit" class="btn btn-success">Update Student</button>
    <a href="studentInfo" class="btn btn-secondary ms-2">Cancel</a>
  </div>
</form>
</body>
</html>
