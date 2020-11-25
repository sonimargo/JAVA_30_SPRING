package dev.springBootH2.Model;

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
	private Long idAutor;
	private String nombre;
	
	
	public Autor() 
	{
		// TODO Auto-generated constructor stub
	}

	@OneToOne
	@JoinColumn (name = "FK_BOOK_ID", updatable = false, nullable = true)
    private Book libro;
	
}
