package scripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Windows 11\\Downloads\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		System.out.println(driver.getTitle());

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

		/*
		 * WebElement textBox = driver.findElement(By.name("my-text")); 
		 * WebElement submitButton = driver.findElement(By.cssSelector("button"));
		 * textBox.sendKeys("Selenium"); 
		 * submitButton.click(); 
		 * driver.quit();
		 */

		// campo texto
		driver.findElement(By.id("my-text-id")).sendKeys("Gabriela");

		// campo password
		driver.findElement(By.name("my-password")).sendKeys("pirata666");

		// campo textArea
		driver.findElement(By.name("my-textarea")).sendKeys("Rellenando desde JAVA");

		// Disabled Input

		// ReadOnly Input

		// Dropdown Menu (select)
		driver.findElement(By.cssSelector("option[value='2']")).click();
		
		// Select dropdown 

		// Dropdown Menu (dataList)
		WebElement dataList = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/input"));
		dataList.sendKeys("Chicago");
		dataList.click();
		
		// FileInput
		
		driver.findElement(By.cssSelector("body > main > div > form > div > div:nth-child(2) > label:nth-child(3) > input"));
		driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[3]/input")).sendKeys("C:\\Users\\Windows 11\\Downloads\\Guía Selenium.pdf");
        //driver.findElement(By.name("my-file")).click();
		
		// Checkbox
		driver.findElement(By.id("my-check-1")).click();
		driver.findElement(By.id("my-check-2")).click();
		
		// RadioButton
		driver.findElement(By.id("my-radio-2")).click();
		
		// Color Picker
		driver.findElement(By.cssSelector("body > main > div > form > div > div:nth-child(3) > label:nth-child(1) > input")).sendKeys("#3D747D");
		//driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[1]/input")).sendKeys("#3D747D");
		//driver.findElement(By.name("my-colors")).sendKeys("#3D747D");
		
		// Date Picker
		WebElement DatePicker = driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[2]/input"));
		DatePicker.sendKeys("23/01/2025");
		WebElement clickFuera = driver.findElement(By.cssSelector("body > main > div"));
		clickFuera.click();
			
		// Example Range
		WebElement range = driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[3]/input"));
		range.sendKeys(Keys.DOWN);
		range.sendKeys(Keys.DOWN);
	}		
}
