package dev.springBootH2.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.springBootH2.Model.Book;
import dev.springBootH2.Repository.BookRepository;


@Service
public class BookService 
{
	@Autowired
	BookRepository repository;
	
	public Iterable<Book> findAll() 
	{
		return repository.findAll();
	}
	
	public void insertBook(Book book) 
	{
		repository.save(book);
	}
	
	public void deleteBook(Book book) 
	{
		repository.delete(book);
	}
	
	public void updateBook(Book book) 
	{
		repository.save(book);
	}
	
	public Optional<Book> findById (long id) 
	{
		return repository.findById(id);
	}

	
}