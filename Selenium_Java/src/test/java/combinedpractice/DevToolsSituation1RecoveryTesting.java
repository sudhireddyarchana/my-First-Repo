package combinedpractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevToolsSituation1RecoveryTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open browser, launch site and close banner 
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.gmail.com");
				DevTools dt=driver.getDevTools();
				try {
					Command c= new Command("Browser.crash",ImmutableMap.of());
					dt.send(c);
				}
				catch(Exception ex)
				{
					System.out.println("continue further testing");
				}
				//recover the site
				try {
					WebDriverManager.chromedriver().setup();
					ChromeDriver driver1= new ChromeDriver();
					driver1.get("https://www.gmail.com");
					Thread.sleep(5000);
					System.out.println("test passed");
					driver1.close();
				}catch(Exception ex)
				{
					System.out.println("test failed");
				
					
				}
				

	}

}
