package dev.springBootH2.Repository;

import org.springframework.data.repository.CrudRepository;

import dev.springBootH2.Model.Autor;


public interface AutorRepository extends CrudRepository<Autor, Long> 
{ 

	Autor findById(long id);

}
