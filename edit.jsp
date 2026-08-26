<%@ page import="student.Student" %>


<%
    Student student =
        (Student) request.getAttribute("student");
%>


<!DOCTYPE html>


<html>


<head>
    <title>Edit Student</title>
</head>


<body>


<h1>Edit Student</h1>


<form action="students" method="post">


    <input type="hidden"
           name="action"
           value="update">


    <input type="hidden"
           name="id"
           value="<%= student.getId() %>">


    <label>Name:</label>


    <input type="text"
           name="name"
           value="<%= student.getName() %>"
           required>


    <br><br>




    <label>Email:</label>


    <input type="email"
           name="email"
           value="<%= student.getEmail() %>"
           required>


    <br><br>




    <label>Age:</label>


    <input type="number"
           name="age"
           value="<%= student.getAge() %>"
           required>


    <br><br>




    <label>Course:</label>


    <input type="text"
           name="course"
           value="<%= student.getCourse() %>"
           required>


    <br><br>




    <button type="submit">
        Update Student
    </button>


</form>


<br>


<a href="students?action=list">
    Back to Student List
</a>


</body>


</html>
