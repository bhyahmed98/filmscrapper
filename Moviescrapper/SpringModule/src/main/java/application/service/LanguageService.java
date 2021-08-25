package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Film;
import application.model.Language;
import application.repository.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository languagerepository;
	
	public List<Language> getAll() {
		return languagerepository.findAll();
	}
	
	public Optional<Language> get(long id) {
		return languagerepository.findById(id);
	}
	
	public void delete(long id) {
		languagerepository.deleteById(id);
	}
	public Language add(Language language) {
		return languagerepository.save(language);
	}
	
	public Language findByName(String name){
		return languagerepository.findByNameLanguage(name);
	} 


	

}
