package scrappers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import lombok.Data;

import java.util.ArrayList;

@Data
public class scrapActor {

	private String dateOfBirth = "";
	private String placeOfBirth = "";
	
	public void scrape(String actorname) {
		final String url = "https://www.rottentomatoes.com/celebrity/";

		try {
			try {

				final Document document = Jsoup.connect(url + actorname.replace(" ", "_")).get();

				for (Element e : document.select("p.celebrity-bio__item")) {

					if (e.text().contains("Birthday:")) {
						String data = e.text();
						dateOfBirth = data.split(":", 2)[1];
						System.out.println(dateOfBirth);
					}
					if (e.text().contains("Birthplace:")) {
						String data = e.text();
						placeOfBirth = data.split(":", 2)[1];
						System.out.println(placeOfBirth);
					}
				}


			} catch (Exception ex) {
				final Document document = Jsoup.connect(url + actorname.replace(" ", "-")).get();
				String dateOfBirth = "";
				String placeOfBirth = "";
				for (Element e : document.select("p.celebrity-bio__item")) {

					if (e.text().contains("Birthday:")) {
						String data = e.text();
						dateOfBirth = data.split(":", 2)[1];
						System.out.println(dateOfBirth);
					}
					if (e.text().contains("Birthplace:")) {
						String data = e.text();
						placeOfBirth = data.split(":", 2)[1];
						System.out.println(placeOfBirth);
					}
				}


			}
		} catch (Exception ex) {
			ArrayList<String> actorinfo = new ArrayList<String>();
			ex.printStackTrace();

		}
	}
}