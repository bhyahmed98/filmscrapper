package application.controller;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Actor;
import application.model.Film;
import application.repository.ActorRepository;
import application.service.ActorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor

public class ActorController {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	ActorService actorService;

	@PostMapping("/add")
	public Actor saveActor(@RequestBody Actor actor) {
		return actorService.Add(actor);
	}
	@CrossOrigin
	@GetMapping("/getall")
	public List<Actor> getAllActor() {
		return actorService.getAll();
	}
	@CrossOrigin
	@GetMapping("/get/{id}")
	public Actor getActor(@PathVariable("id") long id) {
		return actorService.get(id);
	}
	@CrossOrigin
	@GetMapping("/getname/{name}")
	public Actor getActorName(@PathVariable("name") String name) {
		return actorService.findByName(name);
	}
	@CrossOrigin
	@GetMapping("/getfilms/{idactor}")
	public List<Film> getFilms(@PathVariable("idactor") long id) {
		List<Film> results = entityManager.createNativeQuery(
				"select * from film where film.id_film in (select id_film from actfilm where actfilm.id_actor = ?2)")
				.setParameter(2, id).getResultList();
		return results;
	}

	@DeleteMapping("delete/{id}")
	public void deleteActor(@PathVariable("id") long id) {
		actorService.delete(id);
	}

}
