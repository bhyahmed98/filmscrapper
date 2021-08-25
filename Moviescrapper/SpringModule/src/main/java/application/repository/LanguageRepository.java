package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
	Language findByNameLanguage(String name);

}