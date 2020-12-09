package dev.springBootH2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVAS")
public class Reserva 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDRESERVA")
	private Integer idReserva;
	
	@Column(name = "RESERVA")
	private String reserva;

	
	
	
	public Reserva() 
	{
	}




	public Reserva(Integer idReserva, String reserva) {
		super();
		this.idReserva = idReserva;
		this.reserva = reserva;
	}




	public Integer getIdReserva() {
		return idReserva;
	}




	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}




	public String getReserva() {
		return reserva;
	}




	public void setReserva(String reserva) {
		this.reserva = reserva;
	}




	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", reserva=" + reserva + "]";
	}
	
	
	

}
