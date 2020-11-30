package dev.springBootH2.Repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.springBootH2.Model.Book;


public interface BookRepository extends CrudRepository<Book,Long> 
{
	Optional<Book> findById(long id);
}