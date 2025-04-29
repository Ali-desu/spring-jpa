<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
<h1>Students</h1>
<table id="studentsTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Major</th>
        <th>Mark</th>
    </tr>
    </thead>
    <tbody>
    <!-- Rows will be dynamically added here -->
    </tbody>
</table>


<a href="${pageContext.request.contextPath}/api/students">go</a>

<script>
    // Fetch students from the API
    fetch("${pageContext.request.contextPath}/api/students")
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.querySelector('#studentsTable tbody');
            data.forEach(student => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>` + student.id + `</td>
                    <td>` + student.name + `</td>
                    <td>` + student.email + `</td>
                    <td>` + student.major + `</td>
                    <td>` + student.mark + `</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
</script>
</body>
</html>