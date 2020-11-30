package dev.springBootH2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.springBootH2.Model.Cita;
import dev.springBootH2.Repository.CitaRepository;

@Service
public class CitaService 
{

	@Autowired
	CitaRepository repository;

	public Iterable<Cita> findAll() 
	{
		return repository.findAll();
	}
	
	public void insertCita(Cita cita) 
	{
		repository.save(cita);
	}
	
	public void deleteCita(Cita cita) 
	{
		repository.delete(cita);
	}
	
	public void saveCita(Cita cita) 
	{
		repository.save(cita);
	}
	
}
