package application.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import application.model.Language;
import application.service.LanguageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {
	@Autowired
	LanguageService languageservice;

	@PostMapping("/add")
	public Language saveFilm(@RequestBody Language language) {
		return languageservice.add(language);
	}
	@GetMapping("/getall")
	public List<Language> getAllFilm(){
		return languageservice.getAll(); 
	}
	@GetMapping("/get/{id}")
	public Optional<Language> getFilm(@PathVariable("id") long id){
		return languageservice.get(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		languageservice.delete(id);
	}

}
