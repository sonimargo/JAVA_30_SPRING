package dev.springBootH2.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.springBootH2.Model.Autor;
import dev.springBootH2.Model.Cita;
import dev.springBootH2.Repository.CitaRepository;

@Service
public class CitaService 
{

	@Autowired
	CitaRepository repositorioCita;

	
	public Iterable<Cita> findAll() 
	{
		return repositorioCita.findAll();
	}
	
	public void insertCita(Cita cita) 
	{
		repositorioCita.save(cita);
	}
	
	public void deleteCita(Cita cita) 
	{
		repositorioCita.delete(cita);
	}
	
	public void saveCita(Cita cita) 
	{
		repositorioCita.save(cita);
	}
	
	
	public Optional<Cita> findById (long id) 
	{
		return repositorioCita.findById(id);
	}
}
