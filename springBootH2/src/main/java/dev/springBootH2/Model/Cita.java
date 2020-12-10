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
	private Long idCita;
	
	@Column(name = "TEXTOCITA")
	private String textoCita;

	@ManyToOne
	@JoinColumn(name = "FK_AUTOR_ID", nullable = true)
	//@JsonIgnore
	private Autor autorCita;
		
	
	public Cita() 
	{
	}

	public Cita(String cita) 
	{
		super();
		this.textoCita = cita;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", cita=" + textoCita + ", autorCita=" + autorCita + "]";
	}

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public String getTextoCita() {
		return textoCita;
	}

	public void setTextoCita(String cita) {
		this.textoCita = cita;
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
