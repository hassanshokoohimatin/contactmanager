<%@ page import="java.util.List" %>
<%@ page import="model.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show all contacts</title>
    <link href="resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container p-3">
    <h3 class="p-3 text-center">All Contacts</h3>
<table class="table table-success">
    <thead>
    <tr>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Mobile</td>
        <td>Telephone</td>
        <td>Email</td>
        <td>Address</td>
    </tr>
    </thead>
    <tbody>
    <%
        List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
        for (Contact contact : contacts){
    %>
            <tr>
                <td><%=contact.getFirstName()%></td>
                <td><%=contact.getLastName()%></td>
                <td><%=contact.getMobile()%></td>
                <td><%=contact.getTelephone()%></td>
                <td><%=contact.getEmail()%></td>
                <td><%=contact.getAddress()%></td>
            </tr>
    <%
        }
    %>
    </tbody>
</table>
</div>
</body>
</html>
