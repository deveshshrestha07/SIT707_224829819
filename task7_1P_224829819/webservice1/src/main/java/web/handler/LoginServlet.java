package web.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

/**
 * HTTP endpoint to handle login requests.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("[LoginServlet] POST received");

        // Extract form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");

        System.out.println("Received: username=" + username + ", password=" + password + ", dob=" + dob);

        // Authenticate using LoginService
        boolean authenticated = LoginService.login(username, password, dob);

        System.out.println("Login result = " + authenticated);

        // Set response type
        response.setContentType("text/html");

        // Build response HTML
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>" + (authenticated ? "success" : "fail") + "</title></head>");
        out.println("<body>");
        out.println("<h1>Login " + (authenticated ? "Successful" : "Failed") + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
