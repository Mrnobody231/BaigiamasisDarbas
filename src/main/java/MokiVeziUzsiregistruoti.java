import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;

public class MokiVeziUzsiregistruoti extends MokiVeziBase {

    private DbConnection db;


    private static final By Cookies = By.xpath("//*[@id=\"cookie-holder\"]/div/button");
    private static final By Paskyra = By.cssSelector("div[class='input-style-reset basket-btn d-flex align-items-center" +
            " noselect'] span[class='header-categories__link__text ml-1 medium-link']");
    private static final By Uzsiregistruoti = By.cssSelector(".btn.btn-transparent.btn-block.mini-cart__btn");
    private static final By Vardas = By.cssSelector("#sylius_customer_registration_firstName");
    private static final By Pavarde = By.cssSelector("#sylius_customer_registration_lastName");
    private static final By Pastas = By.cssSelector("#sylius_customer_registration_email");
    private static final By TelefonoNumeris = By.cssSelector("#sylius_customer_registration_phoneNumber");
    private static final By Slaptazodis = By.xpath("//*[@id=\"sylius_customer_registration_user_plainPassword_" +
            "first\"]");
    private static final By PakartotiSlaptazodi = By.xpath("//*[@id=\"sylius_customer_registration_user_" +
            "plainPassword_second\"]");
    private static final By reCAPTCHA = By.cssSelector("button[class='btn btn-primary mt-3']");
    private static final By SukurtiPaskyra = By.cssSelector("button[class='btn btn-primary mt-3']");


    public MokiVeziUzsiregistruoti(WebDriver driver) {
        super(driver);
        db = new DbConnection();
    }


    public static void cookie() {
        WebElement cookie = driver.findElement(Cookies);
        cookie.click();
    }

    public static void registruotis() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement paskyra = driver.findElement(Paskyra);
        paskyra.click();

        WebElement uzsiregistruoti = wait.until(ExpectedConditions.visibilityOfElementLocated(Uzsiregistruoti));
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
            WebElement sukurtipask = wait.until(ExpectedConditions.elementToBeClickable(SukurtiPaskyra));
            sukurtipask.click();
            System.out.println("Paskyra sukurta");
        } catch (Exception e) {
            System.out.println("Nepatvirtino Paskyros" + e.getMessage());

        }


            WebElement vardas1 = driver.findElement(Vardas);
            WebElement pavarde1 = driver.findElement(Pavarde);
            WebElement telefononr1 = driver.findElement(TelefonoNumeris);
            WebElement slaptazodis1 = driver.findElement(Slaptazodis);
            String mokiVeziVardas = vardas1.getAttribute("value");
            String mokiVeziPavarde = pavarde1.getAttribute("value");
            String mokiVeziTelefonoNr = telefononr1.getAttribute("value");
            String mokiVeziSlaptazodis = slaptazodis1.getAttribute("value");


            String url = "jdbc:postgresql://localhost/MokiVeziData";
            String user = "postgres";
            String password = "123456";
            try (Connection connection = DriverManager.getConnection(url, user,password)){
                String sql = "INSERT INTO mokiVezi(mokiVeziVardas, mokiVeziPavarde, mokiVeziTelefonoNr, mokiVeziSlaptazodis)" +
                        "Values (?, ?, ?, ?)";

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, mokiVeziVardas);
                statement.setString(2, mokiVeziPavarde);
                statement.setString(3, mokiVeziTelefonoNr);
                statement.setString(4, mokiVeziSlaptazodis);


                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("mokiVezi inserted successfully");
                } else {
                    System.out.println("Failed to insert mokiVezi");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }





