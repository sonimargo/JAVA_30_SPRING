package dev.springBootH2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.springBootH2.Model.Autor;
import dev.springBootH2.Model.Book;
import dev.springBootH2.Repository.AutorRepository;

@Service
public class AutorService 
{
	
	@Autowired
	AutorRepository repositorio;

	public Iterable<Autor> findAll() 
	{
		return repositorio.findAll();
	}

	
	public void insertAutor(Autor autor) 
	{
		repositorio.save(autor);
	}
	
	public void deleteAutor(Autor autor) 
	{
		repositorio.delete(autor);
	}
}
