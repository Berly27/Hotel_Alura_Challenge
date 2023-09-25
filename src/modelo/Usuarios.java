package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConexionBase;

public class Usuarios {
	private String nombre;
	private String contraseña;
	
	public Usuarios(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public static boolean validarUsuario(String nombre, String contraseña) {
		ConexionBase conexion = new ConexionBase();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = conexion.conectarBase();
			statement = connection.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?");
			statement.setString(1, nombre);
			statement.setString(2, contraseña);
			resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if (resultSet !=null)
					resultSet.close();
				if (statement !=null)
					statement.close();
				if (connection !=null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
