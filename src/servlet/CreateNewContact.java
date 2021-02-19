package servlet;

import model.Contact;
import service.ContactRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateNewContact", urlPatterns = "/createNewContact")
public class CreateNewContact extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String mobile = req.getParameter("mobile");
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        if (firstName.trim().equals("") && lastName.trim().equals("")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        try{
            Contact contact = new Contact(
                    firstName, lastName, mobile, telephone, email, address
            );
            ContactRepository.getInstance().save(contact);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }catch (Exception e){
        } }}

