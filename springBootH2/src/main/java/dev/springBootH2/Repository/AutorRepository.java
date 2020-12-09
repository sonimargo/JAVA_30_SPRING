package dev.springBootH2.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.springBootH2.Model.Autor;
import dev.springBootH2.Model.Book;


public interface AutorRepository extends CrudRepository<Autor, Long> 
{ 

	Optional<Autor> findById(long id);

	List<Autor> findByNombre(String nombre);
	
}
