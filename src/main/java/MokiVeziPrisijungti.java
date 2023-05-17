import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MokiVeziPrisijungti extends MokiVeziBase {


    private static final By Paskyra = By.cssSelector("div[class='input-style-reset basket-btn d-flex align-items-center" +
            " noselect'] span[class='header-categories__link__text ml-1 medium-link']");
    private static final By Prisijungti = By.cssSelector(".btn.btn-primary.btn-block.mini-cart__btn.mt-3");
    private static final By VartotojoVardas = By.cssSelector("#_username");
    private static final By Slaptazodis = By.cssSelector("#_password");
    private static final By Prisijungti1 = By.cssSelector("div[class='mt-3'] button[type='submit']");

    public MokiVeziPrisijungti(WebDriver driver) {
        super(driver);

    }
        public static void prisijungti(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement paskyra = driver.findElement(Paskyra);
                paskyra.click();
                System.out.println("Paskyra galima paspausti");

                WebElement prisijungti = driver.findElement(Prisijungti);
                prisijungti.click();

                WebElement vartotojoVardas = driver.findElement(VartotojoVardas);
                vartotojoVardas.sendKeys("andruskevic.e@gmail.com");

                WebElement slaptazodis = driver.findElement(Slaptazodis);
                slaptazodis.sendKeys("MokiVeziTestas");

                WebElement prisijungti1 = driver.findElement(Prisijungti1);
                prisijungti1.submit();
            } catch (Exception e) {
                System.out.println("Prisijungti nepavyko" + e.getMessage());
            }
        }
    }



