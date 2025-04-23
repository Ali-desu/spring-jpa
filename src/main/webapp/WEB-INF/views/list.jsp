<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f9fb;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            color: #2c3e50;
            margin-bottom: 20px;
        }

        a.add-button {
            background-color: #27ae60;
            color: white;
            padding: 10px 20px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: 600;
            margin-bottom: 20px;
            transition: background 0.3s ease;
        }

        a.add-button:hover {
            background-color: #1e8449;
        }

        table {
            width: 100%;
            max-width: 900px;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.05);
            border-radius: 10px;
            overflow: hidden;
        }

        thead {
            background-color: #3498db;
            color: white;
        }

        th, td {
            padding: 14px 20px;
            text-align: left;
        }

        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tbody tr:hover {
            background-color: #eaf4fb;
        }

        td a {
            margin-right: 10px;
            color: #2980b9;
            text-decoration: none;
            font-weight: 500;
        }

        td a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h1>Students</h1>
<a class="add-button" href="${pageContext.request.contextPath}/students/new">Add New Student</a>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Major</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.major}</td>
            <td>
                <a href="${pageContext.request.contextPath}/students/edit/${student.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/students/delete/${student.id}" onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
