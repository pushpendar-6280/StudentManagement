<%@ page import="java.util.List" %>
<%@ page import="student.Student" %>


<!DOCTYPE html>


<html>


<head>
    <title>Student List</title>
</head>


<body>


<h1>All Students</h1>


<a href="add.jsp">
    Add New Student
</a>


<br><br>


<table border="1" cellpadding="10">


    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Course</th>
        <th>Actions</th>
    </tr>


<%


    List<Student> students =
        (List<Student>) request.getAttribute("students");


    for(Student student : students) {


%>


    <tr>


        <td>
            <%= student.getId() %>
        </td>


        <td>
            <%= student.getName() %>
        </td>


        <td>
            <%= student.getEmail() %>
        </td>


        <td>
            <%= student.getAge() %>
        </td>


        <td>
            <%= student.getCourse() %>
        </td>


        <td>


            <a href="students?action=edit&id=<%= student.getId() %>">
                Edit
            </a>


            |


            <a href="students?action=delete&id=<%= student.getId() %>"
               onclick="return confirm('Delete this student?');">
                Delete
            </a>


        </td>


    </tr>


<%
    }
%>


</table>


<br>


<a href="index.html">
    Home
</a>


</body>


</html>
