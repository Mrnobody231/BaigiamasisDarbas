import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MokiVeziTest extends MokiVeziBase {


    private MokiVeziUzsiregistruoti uzsiregistruoti;


public MokiVeziTest(){
    super(driver);
}

@BeforeClass
    public void setUp(){
    System.setProperty("webdriver.chrome.driver","C:/Users/MEDION/Desktop/chromedriver/chromedriver_win32/chromedriver.exe");
    System.setProperty("webdriver.gecko.driver", "C:/Users/MEDION/Desktop/moziladriver/geckodriver-v0.33.0-win64/geckodriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    MokiVeziBase.driver = new ChromeDriver(options);
    FirefoxOptions options1 = new FirefoxOptions();
    options1.addArguments("--disable-notifications");
    MokiVeziBase.driver = new FirefoxDriver(options1);
}


}
