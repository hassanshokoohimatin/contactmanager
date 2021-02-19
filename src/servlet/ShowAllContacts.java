package servlet;

import model.Contact;
import service.ContactRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllContacts", urlPatterns = "/showAllContacts")
public class ShowAllContacts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Contact> contacts = ContactRepository.getInstance().findAll();

        req.setAttribute("contacts", contacts);
        req.getRequestDispatcher("show-all-contacts.jsp").forward(req, resp);
    }
}


