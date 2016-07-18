/**
* The crawler should be limited to one domain. 
* Given a starting URL – say wiprodigital.com - 
* it should visit all pages within the domain, 
* but not follow the links to external sites such as Google or Twitter.
* the output should be a simple site map, showing links to other pages under the same domain, 
* links to static content such as images, and to external URLs
* @author  Sathish Kumar Mani
* @version 1.0
* @since   17-july-2016
*/


package net.webcrawler.ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ListPageLinks 
{
	public static void main(String[] args) 
	{
	
		try{
			
			// The connect(url) method creates a new Connection, and get() fetches and parses a HTML file
			Document doc = Jsoup.connect("http://wiprodigital.com/").get();
			
			// In-order to find the links present in the wiprodigital.com domain, we are using doc.select("a[href]")
			Elements allLinks = doc.select("a[href]");
			
			
			// In-order to find the media(pictures) present in the wiprodigital.com domain,we are using doc.select("[src]")
			Elements allMedia = doc.select("[src]");
			 
			System.out.println("Links in the wiprodigital.com domain\n\n");
			 
			for (Element link : allLinks) {
		
				/* this filter will eliminate the links from google, twitter and other sites. 
				 This will show only the links from wiprodigital.com domain */
				 
				if (link.attr("abs:href").contains("wiprodigital.com"))
					System.out.println(link.attr("abs:href"));
				 
			}
			 
			System.out.println("\n\n Media(images) Links in the wiprodigital.com domain\n\n");
			 
			for (Element link : allMedia){
				
				 //this will show all the image links present in the wiprodigital.com
				 
				if (link.tagName().equals("img"))
						System.out.println(link.attr("abs:src"));
				 
			}		 
			 
		}
		catch(Exception e){
			
			e.printStackTrace();
		}		
	}
}
