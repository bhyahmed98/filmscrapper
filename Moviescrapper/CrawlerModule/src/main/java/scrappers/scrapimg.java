package scrappers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class scrapimg {
	
	private static String movieurl="https://www.imdb.com/title/tt9376612/";
	public static void main(String[] args) {
		
		
		try {
			final Document doc = Jsoup.connect(movieurl).get();
			
			Elements links = doc.getElementsByTag("img");
			//To iterate through the list of links in a list
			int i=0;
			for (Element link : links) {
			  String linkHref = link.attr("src"); 
			  if(linkHref.contains("m.media-amazon.com"))i++;
			  if(i==1) 
				  System.out.println(linkHref);
			
			}
			

			
			
		}catch(Exception e){
			return ;
		}

	
	}
}
