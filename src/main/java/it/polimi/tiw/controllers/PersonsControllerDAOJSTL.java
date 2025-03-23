package it.polimi.tiw.controllers;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;
import it.polimi.tiw.beans.*;
import it.polimi.tiw.DAO.PersonDAO;

@WebServlet("/PersonsControllerDAOJSTL")
public class PersonsControllerDAOJSTL extends HttpServlet {
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
		PersonDAO personDao = new PersonDAO(connection);
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		List<PersonBean> persons;
		try {
			persons = personDao.findPersonsByCity(city);
			String path = "/ShowPersonsJSTL.jsp";
			req.setAttribute("number", persons.size());
			req.setAttribute("persons", persons);
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, res);
		} catch (

		SQLException e) {
			out.append("SQL ERROR");
		} finally {
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