package dev.springBootH2.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.springBootH2.Model.Autor;
import dev.springBootH2.Repository.AutorRepository;

@Service
public class AutorService 
{
	
	@Autowired
	AutorRepository repositorioAutor;

	
	public Iterable<Autor> findAll() 
	{
		return repositorioAutor.findAll();
	}

	
	public void insertAutor(Autor autor) 
	{
		repositorioAutor.save(autor);
	}
	
	public void deleteAutor(Autor autor) 
	{
		repositorioAutor.delete(autor);
	}
	
	public Optional<Autor> findById (long id) 
	{
		return repositorioAutor.findById(id);
	}
}
