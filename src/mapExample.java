import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mapExample {

	static WebDriver driver;
	static String hrefurl;
	
	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	
		// Step 1: Navigate to the website
		driver.get("https://www.rediff.com/");
			
		//Step 2: find all the links
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		
		// Step 3: Loop thru the links and get the individual link by using href attribute.
		for(WebElement link: alllinks) {
			
			hrefurl = link.getAttribute("href");
			
			URL url = new URL(hrefurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			
			if(connection.getResponseCode() == 404) {
				
				System.out.println(hrefurl + " is broken having " + connection.getResponseCode() + " code.");
				
			}else {
				
				System.out.println(hrefurl + " -- " + connection.getResponseCode() + " " + connection.getResponseMessage());
			}
			
			
			}
		}
		
}	
		
		/*
		HashMap<Integer, String> hsbc = new HashMap<Integer, String>();
		hsbc.put(12, "Name1");
		hsbc.put(18, "Name2");
		hsbc.put(11, "Name3");
		hsbc.put(17, "Name4");
		hsbc.put(14, "Name5");
		
		
		
		for(var m : hsbc.entrySet()) {
			
			System.out.println("Key is: " + m.getKey() + " value is: " + m.getValue());
		}
		*/
		
		
		/*
		int a[] ={ 4,5,5,5,4,6,6,9,4};
		Set<Integer> nodup = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int m : a) {
			
			list.add(m);
			nodup.add(m);
		}
		for(int m : nodup) {
			
			
			System.out.println(" " + m + " is repeated " + Collections.frequency(list, m) + " times.");
		}
	
		System.out.println(nodup);
		*/
		
	/*
	 
	 		driver.get("https://www.facebook.com/");
		
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		for(WebElement m: alllinks) {
			
			urladdress = m.getAttribute("href");
			
			try {
				
				URL url = new URL(urladdress);
				url.openConnection().connect();
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				responseCode = conn.getResponseCode();
				if(responseCode == 200) {
					
					System.out.println(url + " -- " + conn.getResponseMessage());
				}else {
					System.out.println(url + " is broken having " + conn.getResponseCode() + " code");
				}
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 */
		
		
		
		



