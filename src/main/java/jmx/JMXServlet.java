package jmx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "JMXServlet", urlPatterns = {"/jmx"}, loadOnStartup = 1)
public class JMXServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.getWriter().print("JMXServlet!");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");
    if (name == null) {
      name = "World";
    }
    request.setAttribute("user", name);
    request.getRequestDispatcher("response.jsp").forward(request, response);
  }

}
