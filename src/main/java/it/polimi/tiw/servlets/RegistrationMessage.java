package it.polimi.tiw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrationmessage")
public class RegistrationMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationMessage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = request.getParameter("message");

		if (message == null || message.isEmpty()) {
			message = "Your registration was succesfully saved";
		}
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>");
		out.println("<HEAD><TITLE>Registration</TITLE></HEAD>");
		out.println("<h3>Registration</h3>");
		out.println("<p>" + message + "</p>");

		out.println("</HTML></BODY>");
		out.close();
	}

}
