package relacion1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej2 {

	public static void actores2(Connection con) throws SQLException {

		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from actor where upper(last_name) = 'JOHANSSON'");

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
