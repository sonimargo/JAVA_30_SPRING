package dev.springBootH2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUTORES")
public class Autor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDAUTOR")
	private Integer idAutor;
	private String nombre;
	private String apellido1;
	

	@OneToOne
	@JoinColumn (name = "FK_BOOK_ID", nullable = true, insertable = false, updatable = false)
    private Book libro;
	
	public Autor() 
	{
		super();
	}

	public Autor(String nombre, String apellido1) 
	{
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}

	
	
	
	
	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer id_Autor) {
		this.idAutor = id_Autor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public Book getLibro() {
		return libro;
	}

	public void setLibro(Book libro) {
		this.libro = libro;
	}

	
	
	
}
