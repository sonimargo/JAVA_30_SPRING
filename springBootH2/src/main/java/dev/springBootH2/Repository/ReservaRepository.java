package dev.springBootH2.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.springBootH2.Model.Reserva;



public interface ReservaRepository extends CrudRepository<Reserva,Long>
{
	Optional<Reserva> findById(long id);
}
