package specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import application.model.Category;
import application.model.Film;
import application.repository.CategoryRepository;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class FilmSpecification implements Specification<Film>{
	private SearchCriteria criteria ; 

	@Autowired
	private  CategoryRepository catrep;
	
	@Override
	public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (criteria.getOperation().equalsIgnoreCase(":")){
			 return criteriaBuilder.like(root.<String>get(criteria.getKey()),"%"+ criteria.getValue().toString()+"%");
		}
		
		return null;
	}
	
	
	public  Specification<Film> hasName(String nameFilm,String sortBy,String Categories) {
		
		
	    return (film, cq, cb) -> {
	    	
	    	List<Predicate> predicates = new ArrayList<>();	
	    	predicates.add(cb.like((film.get("nameFilm")),"%" +nameFilm+"%"));
			
	    	cq.orderBy(cb.desc(film.get("year")));
	    	Predicate p=cb.and(predicates.toArray(new Predicate[0]));
	    	
	    	String[] Categoris = new String [] {"Comedy"};
	    	
	    	List<Category> Catstring = new ArrayList<Category>();
	    	
	    	for(String Cat:Categoris) {
	    		System.out.println(Cat);
	    		if (catrep!=null) {
	    			System.out.println(Cat);
		    		Category c= catrep.findByTitle(Cat);
		    		Catstring.add(c);	    			
	    		}

	    	}
	    	
	    	//Predicate pd = cb.in(film.get("categories")).value(Catstring);
	    	
	    	System.out.println("i'm okey !");
	    	
	    	return p;
	    	//return cb.and(p,pd);
	    	
	    };
	
	
	
	
	}
	/*
	public static Specification<Film> hasCateory(String[] categoriesFilm) {
	    return (film, cq, cb) -> cb.like((film.get("nameFilm")),"%" +nameFilm+"%");
	}
	*/
	/*
	*/
	//	static Specification<Film> titleContains(String year) {return (film, cq, cb) -> cq.orderBy(film.get(year));}



}
