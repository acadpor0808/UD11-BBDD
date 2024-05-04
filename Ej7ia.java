package relacion1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ej7ia {

	public static void consultaCiudades(Connection con, Scanner s) {
		System.out.println("Introduce el nombre del país:");
		String pais = s.nextLine();

		String url = "jdbc:mysql://localhost:3306/sakila";
		String usuario = "root";
		String contrasena = "Usuario0?";

		try {
			String sql = "SELECT * FROM city WHERE country_id = (SELECT country_id FROM country WHERE upper(country) = ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pais.toUpperCase());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("city"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
