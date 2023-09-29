package controladores;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import DAO.ReservaDAO;
import factory.ConexionBase;
import modelo.Reserva;

public class ReservaControlador {

	private ReservaDAO reservaD;

	public ReservaControlador() {
		Connection con = new ConexionBase().conectarBase();
		this.reservaD = new ReservaDAO(con);
	}
	
	public void guardar(Reserva reserva) {
		this.reservaD.guardar(reserva);
	}
	
	public List<Reserva> buscar(){
		return this.reservaD.buscar();
	}
	
	public List<Reserva> buscarId(String id){
		return this.reservaD.buscarId(id);
	}
	
	public void actualizarReserva(LocalDate fechaE, LocalDate fechaS, String valor, String formaPago, Integer id) {
		this.reservaD.actualizar(fechaE, fechaS, valor, formaPago, id);
	}
	
	public void eliminar(Integer id) {
		this.reservaD.eliminar(id);
	}
}
