package application.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import application.model.Film;

@Repository
public class FilmDao {
	EntityManager em;
    List<Film> findFilmByFilmNameAndYear(String filmName, String year,String sortBy) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);

        Root<Film> film = cq.from(Film.class);
        Predicate filmNamePredicate = cb.equal(film.get("nameFilm"), filmName);
        Predicate filmYearPredicate = cb.like(film.get("year"), "%" + year + "%");
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(filmNamePredicate);
        predicates.add(filmYearPredicate);
        Predicate filnalPredicate= cb.and(filmNamePredicate,filmYearPredicate);
        
        cq.where(filnalPredicate);
        
        cq.orderBy(cb.asc(film.get(sortBy)));
       
        TypedQuery<Film> query = em.createQuery(cq);
        return query.getResultList();
    }
}
