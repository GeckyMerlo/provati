package it.polimi.tiw.controllers;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;
import it.polimi.tiw.beans.*;

@WebServlet("/PersonsController")
public class PersonsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;

	public void init() throws ServletException {
		try {
			ServletContext context = getServletContext();
			String driver = context.getInitParameter("dbDriver");
			String url = context.getInitParameter("dbUrl");
			String user = context.getInitParameter("dbUser");
			String password = context.getInitParameter("dbPassword");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			throw new UnavailableException("Can't load database driver");
		} catch (SQLException e) {
			throw new UnavailableException("Couldn't get db connection");
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String city = req.getParameter("city");
		String error = null;
		if (city == null) {
			error = "Parameter city cannot be empty";
			res.sendError(500, error);
			return;
		}
		String query = "SELECT * FROM persons WHERE city = ?";
		ResultSet result = null;
		PreparedStatement pstatement = null;
		List<PersonBean> persons = new ArrayList<PersonBean>();
		try {
			pstatement = connection.prepareStatement(query);
			pstatement.setString(1, city);
			result = pstatement.executeQuery();
			while (result.next()) {
				PersonBean person = new PersonBean();
				person.setID(result.getInt("personID"));
				person.setFirstname(result.getString("firstname"));
				person.setLastname(result.getString("lastname"));
				person.setCity(result.getString("city"));
				persons.add(person);
			}
		} catch (SQLException e) {
			error = "SQL QUERY EXECUTION ERROR";
		} finally {
			try {
				result.close();
			} catch (Exception e1) {
				error = "SQL RESULTSET ERROR";
			}
			try {
				pstatement.close();
			} catch (Exception e1) {
				error = "SQL STATEMENT ERROR";
			}
			if (error == null) {
				String path = "/ShowPersons.jsp";
				req.setAttribute("number", persons.size());
				req.setAttribute("persons", persons);
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				dispatcher.forward(req, res);
			} else {
				res.sendError(500, error);
			}
		}

	}

	public void destroy() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException sqle) {
		}
	}
}