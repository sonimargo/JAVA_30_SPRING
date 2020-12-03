package dev.springBootH2.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.springBootH2.Utilitats.EstadoLibro;

@Entity
@Table(name="BOOKS")
public class Book 
{
    @Id	
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDBOOK")
	private Long idBook;
    
    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "ISBN")
	private String ISBN;
    
    @Column(name = "PAGES")
	private int pages;
    
    @Column(name = "YEAR")
	private int year;
    
    @Column(name = "ESTADO")
	private EstadoLibro estado;

	@ManyToOne
	@JoinColumn(name="FK_AUTOR_ID", nullable=true)
	private Autor autor;
	
	

	public Book(String title, String ISBN, int pages, int year, EstadoLibro estado) 
	{
		super();
		this.title = title;
		this.ISBN = ISBN;
		this.pages = pages;
		this.year = year;
		this.estado = estado;
	}

	public Book(String title) 
    {
		super();
		this.title = title;		
	}

	public Book() 
	{
		super();
	}
	
	

	
	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String Title) {
		this.title = Title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

	public EstadoLibro getEstado() {
		return estado;
	}

	public void setEstado(EstadoLibro estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", title=" + title + ", ISBN=" + ISBN + ", pages=" + pages + ", year=" + year
				+ ", estado=" + estado + ", autor=" + autor + "]";
	}	
	
}