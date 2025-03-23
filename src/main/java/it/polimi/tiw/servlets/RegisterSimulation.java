package it.polimi.tiw.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import it.polimi.tiw.data.Course;
import it.polimi.tiw.data.CoursesManager;

@WebServlet("/register")
public class RegisterSimulation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterSimulation() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] checkedIds = request.getParameterValues("courses");

		if (checkedIds == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
			return;
		}

		// Check that the ids sent are valid == correspond to actual courses
		List<Integer> listIds = new ArrayList<Integer>();
		CoursesManager cm = CoursesManager.getCoursesManagerInstance();

		for (String s : checkedIds) {
			Integer id = Integer.parseInt(s);

			System.out.println(id + " " + cm.existCourseWithId(id));

			if (!cm.existCourseWithId(id)) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters");
				return;
			}
			listIds.add(id);
		}
		if (listIds.size() == 0) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "At least one course must be selected");
			return;
		}

		// ONE INPUT IS VALIDATED, DO WHAT IS NEEDED

		String message = "You have registered to: ";
		for (Integer id : listIds) {
			Course course = cm.getCourseById(id);
			// SIMULATE COURSE REGISTRATION
			message += " " + course.getName();
		}
		response.sendRedirect("registrationmessage?message=" + message);
	}

}
