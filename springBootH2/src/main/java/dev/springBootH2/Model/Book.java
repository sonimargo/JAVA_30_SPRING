package dev.springBootH2.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class Book 
{
    @Id	
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDBOOK")
	private Integer idBook;    
    private String title;
	private String ISBN;
	private int pages;
	private int year;
	private String estado;

	@OneToOne(mappedBy ="libro", cascade= CascadeType.ALL)
	private Autor autor;
	
	
	
	
	
	

	public Book(String title, String ISBN, int pages, int year, String estado) 
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
	
	
	
	
	
	
	
	public Integer getIdBook() {
		return idBook;
	}

	public void setIdBook(Integer idBook) {
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
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
	
}