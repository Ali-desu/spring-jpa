<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${student.id == null ? 'Add Student' : 'Edit Student'}</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f8;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 30px;
        }

        h1 {
            color: #2c3e50;
            margin-bottom: 20px;
        }

        form {
            background: white;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
        }

        label {
            display: block;
            margin: 12px 0 6px;
            font-weight: 600;
            color: #34495e;
        }

        input {
            width: 100%;
            padding: 10px 14px;
            border: 1px solid #ccc;
            border-radius: 6px;
            transition: border-color 0.3s ease;
            font-size: 15px;
        }

        input:focus {
            border-color: #3498db;
            outline: none;
        }

        .error {
            color: #e74c3c;
            font-size: 0.85rem;
            margin-top: 4px;
        }

        button {
            margin-top: 20px;
            width: 100%;
            background-color: #3498db;
            color: white;
            padding: 12px;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        button:hover {
            background-color: #2980b9;
        }

        .back-link {
            margin-top: 20px;
            display: inline-block;
            color: #3498db;
            text-decoration: none;
            font-weight: 500;
        }

        .back-link:hover {
            text-decoration: underline;
        }

        .error-message {
            color: #e74c3c;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<h1>${student.id == null ? 'Add New Student' : 'Edit Student'}</h1>

<c:if test="${not empty errorMessage}">
    <p class="error-message">${errorMessage}</p>
</c:if>

<form:form method="POST"
           action="${pageContext.request.contextPath}${student.id == null ? '/students' : '/students/update/'.concat(student.id)}"
           modelAttribute="student">

    <label for="name">Name</label>
    <form:input path="name" id="name"/>
    <form:errors path="name" cssClass="error"/>

    <label for="email">Email</label>
    <form:input path="email" id="email"/>
    <form:errors path="email" cssClass="error"/>

    <label for="major">Major</label>
    <form:input path="major" id="major"/>
    <form:errors path="major" cssClass="error"/>

    <label for="mark">Mark</label>
    <form:input path="mark" id="mark"/>
    <form:errors path="mark" cssClass="error"/>

    <button type="submit">Save</button>
</form:form>

<a class="back-link" href="${pageContext.request.contextPath}/students">← Back to List</a>

</body>
</html>
