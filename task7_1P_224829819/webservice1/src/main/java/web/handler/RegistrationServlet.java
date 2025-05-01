package web.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

/**
 * HTTP endpoint to handle registration requests.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[RegistrationServlet] GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[RegistrationServlet] POST");

        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");

        // Call registration business logic
        RegistrationService.register(fName, lName, email, dob);

        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("{\"status\": \"ok\"}");
    }
}
