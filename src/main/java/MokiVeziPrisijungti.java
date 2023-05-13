import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MokiVeziPrisijungti extends MokiVeziBase {


    private static final By Paskyra = By.xpath("/html/body/header/div[2]/div/div/nav/div[3]/div/div[2]" +
            "/div/div[2]/div/a[1]");
    private static final By VartotojoVardas = By.cssSelector("#_username");
    private static final By Slaptazodis = By.cssSelector("#_password");
    private static final By Prisijungti = By.cssSelector("div[class='mt-3'] button[type='submit']");

    public MokiVeziPrisijungti(WebDriver driver) {
        super(driver);


    }

    public static void Prisijungti(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement paskyra = driver.findElement(Paskyra);
            paskyra.click();
            System.out.println("Paskyra spaudzia");

            WebElement vartotojoVardas = driver.findElement(VartotojoVardas);
            vartotojoVardas.sendKeys("Edgar");

            WebElement slaptazodis = driver.findElement(Slaptazodis);
            slaptazodis.sendKeys("MokiVeziTestas");

            WebElement prisijungti = driver.findElement(Prisijungti);
            prisijungti.submit();
        }catch(Exception e){
            System.out.println("Prisijungti nepavyko");
        }

    }
}

