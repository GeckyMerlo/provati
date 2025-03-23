package it.polimi.tiw.DAO;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.polimi.tiw.beans.*;

public class PersonDAO {

	private Connection con;

	public PersonDAO(Connection connection) {
		this.con = connection;
	}

	public List<PersonBean> findPersonsByCity(String city) throws SQLException {
		List<PersonBean> persons = new ArrayList<PersonBean>();
		String query = "SELECT * FROM persons WHERE city = ?";
		ResultSet result = null;
		PreparedStatement pstatement = null;
		try {
			pstatement = con.prepareStatement(query);
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

		} finally {
			try {
				result.close();
			} catch (Exception e1) {

			}
			try {
				pstatement.close();
			} catch (Exception e1) {

			}
		}

		return persons;
	}

}
