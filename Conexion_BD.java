package relacion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Conexion_BD {

	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/sakila";
		Scanner s = new Scanner(System.in);
		try {
			con = DriverManager.getConnection(url, "root", "Usuario0?");
			System.out.println("SCARLETT: ");
			Ej1.actores1(con);
			System.out.println("JOHANSON");
			Ej2.actores2(con);
			System.out.println("Actores que contengan una ‘O’ en su nombre.");
			Ej3.nombre(con);
			System.out.println("4. Actores que contengan una ‘O’ en su nombre y en una ‘A’ en su apellido.");
			Ej4.nombrecono_a(con);
			System.out.println("5. Actores que contengan dos ‘O’ en su nombre y en una ‘A’ en su apellido.");
			Ej5.nombrecondoso_unaa(con);
			System.out.println(
					"Ciudades del country 61. Para hacer esta sentencia SQL, debes generar una consulta parametrizada. El parámetro se le pedirá al usuario");
			Ej6.country(con);
			System.out.println(
					"Ciudades del country ‘Spain’. Para hacer esta sentencia SQL, debes generar una consulta parametrizada. El parámetro se le pedirá al usuario.");

			Ej7.country(con);
		
			
		} catch (SQLException e) {
			System.out.println("Error.");
		} finally {
			try {
				con.close();
				s.close();
			} catch (SQLException ei) {
				ei.setStackTrace(null);
			}
		}
	}

}
