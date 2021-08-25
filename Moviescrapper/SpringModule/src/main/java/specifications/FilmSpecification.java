package specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import application.model.Film;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class FilmSpecification implements Specification<Film>{
	private SearchCriteria criteria ; 
	@Override
	public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (criteria.getOperation().equalsIgnoreCase(":")){
			 return criteriaBuilder.like(root.<String>get(criteria.getKey()),"%"+ criteria.getValue().toString()+"%");
		}
		
		return null;
	}

}
