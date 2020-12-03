package dev.springBootH2.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.springBootH2.Model.Cita;

public interface CitaRepository extends CrudRepository<Cita,Long> 
{

	Optional<Cita> findById(long id);

}
