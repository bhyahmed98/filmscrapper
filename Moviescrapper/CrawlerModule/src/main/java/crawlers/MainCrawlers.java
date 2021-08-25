package crawlers;

import java.util.ArrayList;

public class MainCrawlers {
	public static void main(String[] args) {
		String url = "https://primewire.es/movie/the-green-knight-kxw99";
		PrimewireCrawler primewireCrawler = new PrimewireCrawler();
		primewireCrawler.crawl(1, url,new ArrayList<>());
		System.out.println(primewireCrawler.getNameList().size());
	}
}
