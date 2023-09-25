package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Reserva;

public class ReservaDAO {

	private Connection con;

	public ReservaDAO(Connection con) {
		super();
		this.con = con;
	}

	public void guardar(Reserva reserva) {
		String sql = "INSERT INTO reservas (fecha_entrada,fecha_salida,valor,forma_de_pago)" + "VALUES(?,?,?,?)";

		try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setObject(1, reserva.getFechaE());
			pstm.setObject(2, reserva.getFechaS());
			pstm.setString(3, reserva.getValor());
			pstm.setString(4, reserva.getFormaPago());

			pstm.executeUpdate();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					reserva.setId(rst.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
