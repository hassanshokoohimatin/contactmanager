<%@ page import="model.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>edit contact</title>
</head>
<body>
<form action="editAndDeleteContact" method="post">
    <jsp:useBean id="contact" class="model.Contact" scope="request"/>
        <input type="text" name="first_name"
               value="${contact.firstName}"><br>
        <input type="text" name="last_name"
               value="${contact.lastName}"><br>
        <input type="text" name="mobile"
               value="${contact.mobile}"><br>
        <input type="text" name="telephone"
               value="${contact.telephone}"><br>
        <input type="text" name="email"
               value="${contact.email}"><br>
        <input type="text" name="address"
               value="${contact.address}"><br>
        <input type="hidden" name="contact_id"
               value="${contact.id}"><br>
    <input type="submit" value="Update Contact">
</form>
</body></html>



