package relacion1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ej7 {

	/**
	 * En este ejercicio hay que preguntar al usuario un país, lo que será un
	 * String.
	 */
	// Iniciamos creando la clase, que va a ser un void.
	public static void country(Connection con) throws SQLException {
		// Hacemos el try-catch para los errores.
		Scanner s = new Scanner(System.in);
        System.out.println("introduce el nombre del país:");
        String country = s.nextLine().toUpperCase();
		try {
			// Ponemos nuestra consulta sql que esta en el ejercicio, que funciona bien en
			// MySql.
			 String sql = "SELECT * FROM city WHERE country_id = (SELECT country_id FROM country WHERE upper(country) = ?)";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setString(1, country);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                System.out.println(rs.getString("city"));
	            }
	            
	            
	            con.close();
	            s.close();

		} catch (SQLException e) {
			System.out.println("Error. ");
		}

	}

}
