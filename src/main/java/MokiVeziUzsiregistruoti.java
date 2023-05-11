import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MokiVeziUzsiregistruoti extends MokiVeziBase {


    private final By Cookies = By.xpath("//*[@id=\"cookie-holder\"]/div/button");
    private final By Paskyra = By.cssSelector("div[class='input-style-reset basket-btn d-flex align-items-center" +
            " noselect'] span[class='header-categories__link__text ml-1 medium-link']");
    private final By Uzsiregistruoti = By.cssSelector(".btn.btn-transparent.btn-block.mini-cart__btn");
    private final By Vardas = By.cssSelector("#sylius_customer_registration_firstName");
    private final By Pavarde = By.cssSelector("#sylius_customer_registration_lastName");
    private final By Pastas = By.cssSelector("#sylius_customer_registration_email");
    private final By TelefonoNumeris = By.cssSelector("#sylius_customer_registration_phoneNumber");
    private final By Slaptazodis = By.xpath("//*[@id=\"sylius_customer_registration_user_plainPassword_" +
            "first\"]");
    private final By PakartotiSlaptazodi = By.xpath("//*[@id=\"sylius_customer_registration_user_" +
            "plainPassword_second\"]");
    private final By reCAPTCHA = By.cssSelector("button[class='btn btn-primary mt-3']");
    private final By SukurtiPaskyra = By.cssSelector("button[class='btn btn-primary mt-3']");


    public MokiVeziUzsiregistruoti(WebDriver driver){
        super(driver);
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/MEDION/Desktop/chromedriver/chromedriver_win32/" +
                "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        MokiVeziBase.driver = new ChromeDriver(options);
        MokiVeziBase mokiVeziBase = new MokiVeziBase(driver);
        MokiVeziUzsiregistruoti mokiVeziUzsiregistruoti = new MokiVeziUzsiregistruoti(driver);
        mokiVeziBase.goTo();
        mokiVeziUzsiregistruoti.Cookie();
        mokiVeziUzsiregistruoti.Registruotis();

    }

    public void Cookie() {
        WebElement cookie = driver.findElement(Cookies);
        cookie.click();
    }

    public void Registruotis() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement paskyra = driver.findElement(Paskyra);
        paskyra.click();

        WebElement uzsiregistruoti = wait.until(ExpectedConditions.presenceOfElementLocated(Uzsiregistruoti));
        if (uzsiregistruoti.isDisplayed()) {
            uzsiregistruoti.click();
        } else {
            System.out.println("Nematau uzsiregistruoti");
        }

            WebElement vardas = driver.findElement(Vardas);
            vardas.sendKeys("Edgar");
            WebElement pavarde = driver.findElement(Pavarde);
            pavarde.sendKeys("Andruskevic");
            WebElement pastas = driver.findElement(Pastas);
            pastas.sendKeys("andruskevic.e@gmail.com");
            WebElement telefononr = driver.findElement(TelefonoNumeris);
            telefononr.sendKeys(String.valueOf(860428558));
            WebElement slaptazodis = driver.findElement(Slaptazodis);
            slaptazodis.sendKeys("MokiVeziTestas");
            WebElement pakartotislap = driver.findElement(PakartotiSlaptazodi);
            pakartotislap.sendKeys("MokiVeziTestas");
        try {
            WebElement reCaptha = wait.until(ExpectedConditions.elementToBeClickable(reCAPTCHA));
            reCaptha.submit();
            System.out.println("recaptha patvirtino");
            WebElement sukurtipask = driver.findElement(SukurtiPaskyra);
            sukurtipask.submit();
            System.out.println("Paskyra sukurta");
        } catch (Exception e) {
            System.out.println("Nepatvirtino Paskyros" + e.getMessage());

        }

    }
}
