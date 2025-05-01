package web.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to handle welcome responses.
 */
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[WelcomeServlet] GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[WelcomeServlet] POST");
        resp.getWriter().println("Welcome, server is running!");
    }
}
