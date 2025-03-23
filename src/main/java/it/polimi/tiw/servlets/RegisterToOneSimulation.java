package it.polimi.tiw.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import it.polimi.tiw.data.Course;
import it.polimi.tiw.data.CoursesManager;

@WebServlet("/registerToCourse")
public class RegisterToOneSimulation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterToOneSimulation() {
		super();
	}

	
	/* Similar to /register, but for only 1 course */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_param = request.getParameter("course");
		if (id_param == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
			return;
		}

		// Check that the id sent is valid == correspond to actual course

		CoursesManager cm = CoursesManager.getCoursesManagerInstance();

		Integer id = Integer.parseInt(id_param);
		if (!cm.existCourseWithId(id)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameter");
			return;
		}
		// SIMULATE COURSE REGISTRATION
		Course course = cm.getCourseById(id);
		String message = "You have registered to: " + course.getName();
		response.sendRedirect("registrationmessage?message=" + message);
	}

}
