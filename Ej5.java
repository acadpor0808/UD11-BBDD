package relacion1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej5 {

	public static void nombrecondoso_unaa(Connection con) throws SQLException {

		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT * FROM ACTOR WHERE upper(first_name) LIKE '%O%O%' AND upper(last_name) like '%A%';");

			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String update = rs.getString(4);
				System.out.println("ACTOR CON ID " + id + " y nombre " + nombre + " con apellidos " + apellidos
						+ " el update " + update);
			}

		} catch (SQLException e) {
			System.out.println("Error");
		}

	}
}
