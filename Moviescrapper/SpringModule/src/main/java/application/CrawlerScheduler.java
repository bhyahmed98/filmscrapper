package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import application.model.Actor;
import application.model.Category;
import application.model.Film;
import application.model.Language;
import application.repository.ActorRepository;
import application.repository.CategoryRepository;
import application.repository.FilmRepository;
import application.repository.LanguageRepository;
import crawlers.ChillCrawler;
import crawlers.MoviestarsCrawler;
import crawlers.PapystreamingCrawler;
import crawlers.PrimewireCrawler;
import scrappers.WebScrap;
import scrappers.scrapActor;

@Component
@EnableScheduling
@EnableConfigurationProperties
public class CrawlerScheduler {
	@Autowired
	private ActorRepository actrep;
	@Autowired
	private FilmRepository filmrep;
	@Autowired
	private CategoryRepository catrep;
	@Autowired
	private LanguageRepository langrep;

	// a = nameList.get(i)
	// b = urlList.get(i)

	public void filmFilling(String a, String b, String c) {
		WebScrap webscrap = new WebScrap();
		webscrap.movieTranslation(a, b);

		Film film = new Film();

		film.setNameFilm(webscrap.getTranslatedMovie());
		film.setCurrentRate(webscrap.getImdbRating());
		film.setYear(webscrap.getMovieYear());
		film.setImg("https://m.media-amazon.com/images/M/MV5BMDQ0MWEzMDEtMGZmNC00NjQ0LWJlNDItZDMyNDc5MmFkODJjXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg");

		if (webscrap.getCategory() == null) {
			System.out.println(film.getLinkChill());
			return;
		}
		if (webscrap.getActors() == null) {
			System.out.println(film.getLinkChill());
			return;
		}

		Set<Actor> setact = new HashSet<Actor>();

		for (String j : webscrap.getActors()) {

			Actor actor = new Actor();
			actor.setNameActor(j);
			//scrapActor scrapactor = new scrapActor();
			//scrapactor.scrape(j);
			//actor.setDateActor(scrapactor.getDateOfBirth());
			//actor.setPlaceActor(scrapactor.getPlaceOfBirth());

			if (actrep.findByNameActor(actor.getNameActor()) == null) {
				actrep.save(actor);
				setact.add(actor);
			} else {
				setact.add(actrep.findByNameActor(actor.getNameActor()));
			}

		}

		Set<Category> setcat = new HashSet<Category>();

		for (String j : webscrap.getCategory()) {

			Category category = new Category();

			category.setTitle(j);

			if (catrep.findByTitle(category.getTitle()) == null) {
				catrep.save(category);
				setcat.add(category);
			} else {
				setcat.add(catrep.findByTitle(category.getTitle()));
			}

		}

		Set<Language> setlang = new HashSet<Language>();

		for (String j : webscrap.getLanguages()) {
			Language language = new Language();
			language.setNameLanguage(j);

			if (langrep.findByNameLanguage(language.getNameLanguage()) == null) {
				langrep.save(language);
				setlang.add(language);
			} else {
				setlang.add(langrep.findByNameLanguage(language.getNameLanguage()));
			}

		}

		film.setCategories(setcat);
		film.setActors(setact);
		film.setLanguages(setlang);

		if (c == "chill")
			film.setLinkChill(b);
		if (c == "moviestars")
			film.setLinkMoviestars(b);
		if (c == "papystreaming")
			film.setLinkPapystreaming(b);
		if (c == "primewire")
			film.setLinkPrimeware(b);

		if ((filmrep.findByNameFilm(film.getNameFilm()) == null)) {
			//if ((c == "primewire") && (filmrep.findByLinkPrimeware(film.getLinkPrimeware()) != null))return;
			filmrep.save(film);
		}

		

		if (filmrep.findByNameFilm(film.getNameFilm()) != null) {

			Film f = filmrep.findByNameFilm(film.getNameFilm());
			if (c == "chill")
				f.setLinkChill(b);
			if (c == "moviestars")
				f.setLinkMoviestars(b);
			if (c == "papystreaming")
				f.setLinkPapystreaming(b);
			if (c == "primewire")
				f.setLinkPrimeware(b);

			filmrep.save(f);

		}

	}

	@Bean
	//@Scheduled(fixedRate = 600000)
	public void scheduleFixedRateTask() {

		System.out.println("******************* chill *******************");
		String url = "https://123chill.to/watch-max-and-me-online/";
		ChillCrawler chillCrawler = new ChillCrawler();
		chillCrawler.setUrlList(new ArrayList<>());
		chillCrawler.setNameList(new ArrayList<>());

		chillCrawler.crawl(1, url, new ArrayList<>());
		ArrayList<String> urlList = chillCrawler.getUrlList();
		ArrayList<String> nameList = chillCrawler.getNameList();

		for (int i = 0; i < urlList.size(); i++) {
			filmFilling(nameList.get(i), urlList.get(i), "chill");
		}
		
		
		System.out.println("******************* moviestars *******************");
		
		url = "https://moviestars.to/movie/happy-cleaners-24245"; MoviestarsCrawler
		moviestarscrawler = new MoviestarsCrawler();
		
		moviestarscrawler.setUrlList(new ArrayList<>());
		moviestarscrawler.setNameList(new ArrayList<>());
		
		ArrayList<String> vis= new ArrayList<>(); vis.add("https://moviestars.to/");
		moviestarscrawler.crawl(1, url,vis);
		
		urlList = moviestarscrawler.getUrlList(); nameList =
		moviestarscrawler.getNameList();
		
		for (int i = 0; i < urlList.size(); i++) { filmFilling(nameList.get(i),
		urlList.get(i),"moviestars"); }
		
		
		
		System.out.println("******************* papystreaming *******************");
		url = "https://vvw.papystreaming.stream/arrete-ou-je-continue/";
		PapystreamingCrawler papystreamingCrawler = new PapystreamingCrawler();
		papystreamingCrawler.setUrlList(new ArrayList<>());
		papystreamingCrawler.setNameList(new ArrayList<>());
		
		papystreamingCrawler.crawl(1, url, new ArrayList<>()); urlList =
		papystreamingCrawler.getUrlList(); nameList =
		papystreamingCrawler.getNameList();
		
		for (int i = 0; i < urlList.size(); i++) { filmFilling(nameList.get(i),
		urlList.get(i),"papystreaming"); }
		
		
		System.out.println("******************* primewire *******************");
		url = "https://primewire.es/movie/the-green-knight-kxw99";
		PrimewireCrawler primewireCrawler = new PrimewireCrawler();
		primewireCrawler.setUrlList(new ArrayList<>());
		primewireCrawler.setNameList(new ArrayList<>());
		
		primewireCrawler.crawl(1, url, new ArrayList<>());
		urlList = primewireCrawler.getUrlList();
		nameList = primewireCrawler.getNameList();
		
		for (int i = 0; i < urlList.size(); i++) {
			filmFilling(nameList.get(i), urlList.get(i), "primewire");
		}
		
		
	}

}
