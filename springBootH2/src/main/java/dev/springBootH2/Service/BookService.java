package dev.springBootH2.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.springBootH2.Model.Book;
import dev.springBootH2.Repository.BookRepository;


@Service
public class BookService 
{
	@Autowired
	BookRepository repositorioBook;
	
	
	public Iterable<Book> findAll() 
	{
		return repositorioBook.findAll();
	}
	
	public Optional<Book> findById (long id) 
	{
		return repositorioBook.findById(id);
	}
	
	public void insertBook(Book book) 
	{
		repositorioBook.save(book);
	}
	
	public void deleteBook(Book book) 
	{
		repositorioBook.delete(book);
	}
	
	public void updateBook(Book book) 
	{
		repositorioBook.save(book);
	}
	


	
}