package dev.springBootH2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CITAS")
public class Cita 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDCITA")
	private Integer idCita;
	
	@Column(name = "CITA")
	private String cita;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_AUTOR_ID", nullable = true)
	@JsonIgnore
	private Autor autorCita;
		
	
	public Cita() 
	{
	}

	public Cita(Integer idCita, String cita) 
	{
		super();
		this.idCita = idCita;
		this.cita = cita;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", cita=" + cita + ", autorCita=" + autorCita + "]";
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public String getCita() {
		return cita;
	}

	public void setCita(String cita) {
		this.cita = cita;
	}

	public Autor getAutor() 
	{
		return autorCita;
	}


	public void setAutor(Autor autor) 
	{
		this.autorCita = autor;
	}

}
