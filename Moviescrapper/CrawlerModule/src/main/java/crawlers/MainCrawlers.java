package crawlers;

import java.util.ArrayList;

public class MainCrawlers {
	public static void main(String[] args) {
		String url = "https://123chill.watch/film/the-green-knight";
		url="https://123chill.to/the-green-knight/";
		ChillCrawler cc = new ChillCrawler();
		cc.crawl(1, url,new ArrayList<>());
		System.out.println(cc.getNameList().size());
	}
}
