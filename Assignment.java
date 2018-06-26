
package assignment;
import java.util.ArrayList;
import javax.swing.Spring;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\rajkeshri\\Downloads\\chromedriver_win32\\chromedriver.exe");
    WebDriver wd=new ChromeDriver();
    wd.get("http://10.0.1.86/tatoc");
    wd.findElement(By.linkText("Basic Course")).click();
    wd.findElement(By.className("greenbox")).click();
    Boolean b=true;
    wd.switchTo().frame("main");
    String AA = wd.findElement(By.id("answer")).getAttribute("class");	
    while(b){
       wd.findElement(By.linkText("Repaint Box 2")).click();
       WebElement child = wd.findElement(By.id("child"));
       wd.switchTo().frame(child);
       String EA = wd.findElement(By.id("answer")).getAttribute("class");
       wd.switchTo().parentFrame();
       if(AA.equals(EA)) {
	b = false;
	}
    }
                wd.findElement(By.linkText("Proceed")).click();
                wd.switchTo().defaultContent();
	        Actions act=new Actions(wd);
			WebElement dg=wd.findElement(By.id("dragbox"));
			WebElement dp=wd.findElement(By.id("dropbox"));
		        act.dragAndDrop(dg, dp).build().perform();
                         wd.findElement(By.linkText("Proceed")).click();
                wd.findElement(By.linkText("Launch Popup Window")).click();
                    ArrayList<String> tabs2 = new ArrayList<String> (wd.getWindowHandles());
                    wd.switchTo().window(tabs2.get(1));
                    wd.findElement(By.cssSelector("#name")).sendKeys("hello world");
                    wd.findElement(By.cssSelector("#submit")).click();
                    wd.switchTo().window(tabs2.get(0));
                    wd.findElement(By.linkText("Proceed")).click();
                 wd.findElement(By.linkText("Generate Token")).click();
                 String Token = wd.findElement(By.id("token")).getText();
                 String[] splited = Token.split("\\s+"); 
                 Cookie token1 = new Cookie("Token", splited[1]);
                 wd.manage().addCookie(token1);
                 wd.findElement(By.linkText("Proceed")).click();
                 Thread.sleep(1000);
                 
                 wd.close();
                 
                          
                        
    }
    
}
