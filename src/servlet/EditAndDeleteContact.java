package servlet;
import model.Contact;
import service.ContactRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "EditAndDeleteContact", urlPatterns = "/editAndDeleteContact")
public class EditAndDeleteContact extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        Integer contactId = Integer.parseInt(req.getParameter("contact_id"));
        if (action.equals("delete")){
            try {
                Contact contact = ContactRepository.getInstance().findById(contactId);
                ContactRepository.getInstance().remove(contact);
                req.setAttribute("contacts", ContactRepository.getInstance().findAll());
                req.getRequestDispatcher("show-all-contacts.jsp").forward(req, resp);
            }
            catch (Exception e){
                throw new ServletException(e);
            }
        }
        if (action.equals("edit")){
            try {
                Contact contact = ContactRepository.getInstance().findById(contactId);
                req.setAttribute("contact", contact);
                req.getRequestDispatcher("edit-contact.jsp").forward(req, resp);
            }
            catch (Exception e){
                throw new ServletException(e);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String mobile = req.getParameter("mobile");
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Integer contactId = Integer.parseInt(req.getParameter("contact_id"));
        if (firstName.trim().equals("") && lastName.trim().equals("")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        try{
            Contact contact = ContactRepository.getInstance().findById(contactId);
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setMobile(mobile);
            contact.setTelephone(telephone);
            contact.setEmail(email);
            contact.setAddress(address);
            ContactRepository.getInstance().update(contact);
            req.setAttribute("contacts", ContactRepository.getInstance().findAll());
            req.getRequestDispatcher("show-all-contacts.jsp").forward(req, resp);
        }
        catch (Exception e){
            throw new ServletException(e);
        }
    }
}






