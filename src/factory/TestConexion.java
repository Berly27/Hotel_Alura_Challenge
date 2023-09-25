package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) throws SQLException {
		
		ConexionBase con = new ConexionBase();
		Connection conectarB = con.conectarBase();
		
		System.out.println("Conecto bien");
		
		conectarB.close();
		System.out.println("Cerro bien");
	}
}
