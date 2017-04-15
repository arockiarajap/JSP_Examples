/**
 * 
 */
package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Arockia
 *
 */
@WebServlet(urlPatterns = {"/AcmeReaderServlet"}, asyncSupported=true)
public class ReaderServlet extends HttpServlet {

	private static final long serialVersionUID = 688855970340521628L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter output = response.getWriter()) {
			output.println("<html>");
			output.println("<head>");
			output.println("<title>Acme Reader</title>");
			output.println("</head>");
			output.println("<body>");
			output.println("<h1>Welcome to the Acme Reader Servlet</h1>");
			output.println("<br/><br/>");
			output.println("<p>Look at the server log to see data that was read asynchronously from a file<p>");
			AsyncContext asyncCtx = request.startAsync();
			ServletInputStream input = request.getInputStream();
			input.setReadListener(new ReadFileListener(input, asyncCtx));
			output.println("</body>");
			output.println("</html>");
		} catch (Exception ex) {
			System.out.println("Exception Occurred: " + ex);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
