<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">
<h2 class="text-center mb-4">Add New Student</h2>

<form action="addStudent" method="post" class="mx-auto" style="max-width: 500px;">
    <div class="mb-3">
        <label for="code" class="form-label">Student Code</label>
        <input type="text" class="form-control" id="code" name="code" required>
    </div>
    <div class="mb-3">
        <label for="name" class="form-label">Full Name</label>
        <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <input type="text" class="form-control" id="address" name="address">
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-success">Add Student</button>
        <a href="studentInfo" class="btn btn-secondary ms-2">Cancel</a>
    </div>
</form>
</body>
</html>
