package dev.springBootH2.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.springBootH2.Model.Reserva;
import dev.springBootH2.Model.Usuario;
import dev.springBootH2.Repository.UsuarioRepository;

@Service
public class UsuarioService 
{
	@Autowired
	UsuarioRepository repositorioUsuario;

	public Iterable<Usuario> findAll() 
	{
		return repositorioUsuario.findAll();
	}

	public Optional<Usuario> findById (long id) 
	{
		return repositorioUsuario.findById(id);
	}
	
	
	
	public void insertReserva(Usuario usuario) 
	{
		repositorioUsuario.save(usuario);
	}
	
	public void deleteReserva(Usuario usuario) 
	{
		repositorioUsuario.delete(usuario);
	}
	
	public void saveReserva(Usuario usuario) 
	{
		repositorioUsuario.save(usuario);
	}
}
