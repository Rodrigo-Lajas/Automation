import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5 {
    private WebDriver driver;

    //indica por medio de junit la configuracion para este test (clase loginTest)
    @Before
    public void setUp(){
        //indica donde esta el driver con el que voy a automatizar
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        //le indicamos a la variable driver de selenium, que vamos a trabajar con el driver de chrome
        driver = new ChromeDriver();
        //maximizar la pantalla
        driver.manage().window().maximize();
        //indicar al driver que se dirija a la pagina que vamos a testear
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    //el cuerpo de la automatizacion
    @Test
    public void testGetCssValue(){


        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement botonLogin = driver.findElement(By.xpath("//input[@id='login-button']"));

        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        botonLogin.click();

        WebElement itemPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        String fontSize = itemPrice.getCssValue("font-size");
        String expectedFontSize = "20px";
        if (fontSize.equals(expectedFontSize)) {
            System.out.println("El tamaño de fuente (" + expectedFontSize + ") es el correcto");
        } else {
            System.out.println("El tamaño de fuente no es el correcto. El tamaño esperado es" + expectedFontSize);
        }
    }

    //indica lo que se realiza luego de terminar el test
    @After
    public void tearDown(){
        driver.quit();
    }
}
