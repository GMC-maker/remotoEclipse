package scriptsSelenium;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

public class PaginaPrueba2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Windows 11\\Downloads\\Instaladores\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        try {
            // Maximizar ventana y configurar tiempos de espera
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Navegar a la página
            driver.get("http://opencart.abstracta.us/");
            
            // Búsqueda
            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.name("search")));
            search.sendKeys("samsung tablet");
            
            
            // Carrito
            WebElement carrito = wait.until(ExpectedConditions.elementToBeClickable(By.id("cart")));
            carrito.click();
            
            // Cambio de moneda
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#form-currency > div > button")));
            menu.click();
            
            WebElement currency = wait.until(ExpectedConditions.elementToBeClickable(By.name("EUR")));
            currency.click();
            
            // Scroll suave hasta el botón de agregar al carrito
            WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(1)")
            ));
            
            // Hacer scroll suave
            int elementPosition = addToCartButton.getLocation().getY();
            for (int i = 0; i <= elementPosition; i += 100) {
                js.executeScript("window.scrollTo(0, " + i + ")");
                Thread.sleep(100);
            }
            
            // Esperar y hacer clic
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCartButton.click();
            
            // Esperar para ver el resultado
            Thread.sleep(2000);
            
            // Esperar a que se actualice el carrito
            Thread.sleep(1000);
            
            // Ver el contenido del carrito
            WebElement verCarrito = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart > button")));
            verCarrito.click();
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
           // driver.quit();
        }
    }
}



