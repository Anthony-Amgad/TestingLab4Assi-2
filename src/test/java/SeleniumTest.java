import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {

    static WebDriver driver;
    static final String Website = "https://formy-project.herokuapp.com/form";

    @BeforeAll
    public static void init(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
    @BeforeEach
    public void BE(){
        driver.get(Website);
    }

    @Test
    public void test1(){
        WebElement fN = driver.findElement(By.id("first-name"));
        WebElement lN = driver.findElement(By.id("last-name"));
        WebElement jT = driver.findElement(By.id("job-title"));
        WebElement cR = driver.findElement(By.id("radio-button-2"));

        fN.sendKeys("Anthony");
        lN.sendKeys("Selim");
        jT.sendKeys("Student");
        cR.click();

        assertEquals(fN.getAttribute("value"),"Anthony");
        assertEquals(lN.getAttribute("value"),"Selim");
        assertEquals(jT.getAttribute("value"),"Student");
        assertTrue(cR.isSelected());

        WebElement btn = driver.findElement(By.className("btn"));

        btn.click();
    }


}
