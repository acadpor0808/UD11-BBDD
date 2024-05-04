package relacion1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej1 {

	static void actores1(Connection con) throws SQLException {

		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from actor where upper(first_name) = 'SCARLETT'");

			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				System.out.println("ACTOR CON ID " + id + " y nombre " + nombre + " con apellidos " + apellidos);
			}

		} catch (SQLException e) {
			System.out.println("Error");
		}

	}
}
