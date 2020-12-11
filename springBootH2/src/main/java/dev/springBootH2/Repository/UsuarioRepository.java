package dev.springBootH2.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.springBootH2.Model.Book;
import dev.springBootH2.Model.Usuario;



public interface UsuarioRepository extends CrudRepository<Usuario,Long> 
{
	Optional<Usuario> findById(long id);
	
	Optional<Usuario> findByUsuario(String usuari);
}
