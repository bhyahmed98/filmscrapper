package application.repository;

import java.util.List;

import application.model.Film;

public interface FilmRepositoryCustom {
	List<Film> findFilmByFilmNameAndYear(String filmName, String year);

}
