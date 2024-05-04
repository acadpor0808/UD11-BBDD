package relacion1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ej6 {

	public static void country(Connection con) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un valor ");
		int n = sc.nextInt();
		String sql = "SELECT * FROM CITY WHERE COUNTRY_ID=?;";

		try {
			Statement s = con.createStatement();
			PreparedStatement statment = con.prepareStatement(sql);

			statment.setInt(1, n);
			ResultSet rs = statment.executeQuery();

			while (rs.next()) {
				String nombreCiudad = rs.getString("city");

				System.out.println(nombreCiudad);

			}

			s.close();
			statment.close();
			sc.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println("Error");
		}

	}
}
