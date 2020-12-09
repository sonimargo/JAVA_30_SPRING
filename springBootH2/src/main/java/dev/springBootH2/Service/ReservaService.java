package dev.springBootH2.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.springBootH2.Model.Cita;
import dev.springBootH2.Model.Reserva;
import dev.springBootH2.Repository.ReservaRepository;

@Service
public class ReservaService 
{

	@Autowired
	ReservaRepository repositorioReserva;
	
	public Iterable<Reserva> findAll() 
	{
		return repositorioReserva.findAll();
	}

	public Optional<Reserva> findById (long id) 
	{
		return repositorioReserva.findById(id);
	}
	
	
	
	public void insertReserva(Reserva reserva) 
	{
		repositorioReserva.save(reserva);
	}
	
	public void deleteReserva(Reserva reserva) 
	{
		repositorioReserva.delete(reserva);
	}
	
	public void saveReserva(Reserva reserva) 
	{
		repositorioReserva.save(reserva);
	}
}
