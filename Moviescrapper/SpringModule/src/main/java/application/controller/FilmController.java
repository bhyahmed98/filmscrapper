package application.controller;

import java.util.ArrayList;
import java.util.List;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Actor;
import application.model.Category;
import application.model.Film;
import application.model.Language;
import application.repository.FilmRepository;
import application.service.FilmService;
import lombok.RequiredArgsConstructor;
import specifications.FilmSpecification;

@RestController
@RequestMapping("/film")
@RequiredArgsConstructor

public class FilmController {
  
 	@Autowired
    FilmService filmService;
 	
	@Autowired
	private FilmRepository filmRepository;
	
	
	private FilmSpecification fs;
	
   
    @PostMapping("/add")
    public Film saveFilm(@RequestBody Film film) {
		return filmService.add(film); 
	}
    
    @CrossOrigin
	@PostMapping("/getall")
	public List<Film> getAllFilm(@RequestBody List<String> liste){
    	//liste=(String) liste.subSequence(1, liste.length()-1);
    	
    	String a= liste.get(2);   	
    	return filmRepository.findAll(fs.hasName(a));
		
    	//return filmService.getAll(liste); 
	}
    
    @CrossOrigin
	@GetMapping("/get/{id}")
	public Optional<Film> getFilm(@PathVariable("id") long id){
		return filmService.get(id);
	}
    @CrossOrigin
	@GetMapping("/getname/{name}")
	public Film getFilmName(@PathVariable("name") String name){
		return filmService.findByName(name);
	}
    @CrossOrigin
	@GetMapping("/getactors/{name}")
	public Set<Actor> getActorName(@PathVariable("name") String name){
		return filmService.findByName(name).getActors();
	}
    @CrossOrigin
	@GetMapping("/getcategories/{name}")
	public Set<Category> getCategoryName(@PathVariable("name") String name){
		return filmService.findByName(name).getCategories();
	}
    @CrossOrigin
	@GetMapping("/getlanguages/{name}")
	public Set<Language> getLanguageName(@PathVariable("name") String name){
		return filmService.findByName(name).getLanguages();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		filmService.delete(id);
	}
	
	

	
}
