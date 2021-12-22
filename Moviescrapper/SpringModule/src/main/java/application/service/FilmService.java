package application.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import application.model.Film;
import application.repository.FilmRepository;
import specifications.FilmSpecification;
import specifications.SearchCriteria;


@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;

	public List<Film> getAll(String liste) {
		//FilmSpecification filmSpecification=new FilmSpecification (new SearchCriteria ("nameFilm",":",liste), null) ; 
		//return filmRepository.findAll(Objects.requireNonNull(Specification.where(filmSpecification)));
		return filmRepository.findAll();
		
	}
	
	public Optional<Film> get(long id) {
		return filmRepository.findById(id);
	}
	public void delete(long id) {
		filmRepository.deleteById(id);
	}
	public Film add(Film film) {
		return filmRepository.save(film);
	}
	public Film findByName(String name){
		return filmRepository.findByNameFilm(name);
	} 

}
