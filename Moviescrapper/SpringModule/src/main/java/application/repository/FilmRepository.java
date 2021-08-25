package application.repository;



import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import application.model.Film;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long>,JpaSpecificationExecutor<Film> {
	
	
	Film findByNameFilm(String name);
	Film findByLinkPrimeware(String name);

}