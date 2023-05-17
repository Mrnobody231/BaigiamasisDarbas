import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




    public class MokiVeziTest extends MokiVeziBase {

        private MokiVeziUzsiregistruoti uzsiregistruoti;
        private MokiVeziPrisijungti prisijungti;
        private MokiVeziIspardavimas ispardavimas;


        public MokiVeziTest() {
            super(driver);
        }

        @BeforeClass
        public static void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:/Users/MEDION/Desktop/chromedriver/chromedriver_win32/" +
                    "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            MokiVeziBase.driver = new ChromeDriver(options);
            MokiVeziBase mokiVeziBase = new MokiVeziBase(driver);
            MokiVeziUzsiregistruoti mokiVeziUzsiregistruoti = new MokiVeziUzsiregistruoti(driver);
            MokiVeziPrisijungti mokiVeziPrisijungti = new MokiVeziPrisijungti(driver);
            MokiVeziIspardavimas mokiVeziIspardavimas = new MokiVeziIspardavimas(driver);
            mokiVeziBase.goTo();
            mokiVeziIspardavimas.prekiuIspardavimas();
            mokiVeziUzsiregistruoti.cookie();
            mokiVeziUzsiregistruoti.registruotis();
            mokiVeziPrisijungti.prisijungti();

        }

        @Test
        public void MokiVeziUzsiregistruotiTest() {
            MokiVeziBase.goTo();
            MokiVeziUzsiregistruoti.cookie();
            MokiVeziUzsiregistruoti.registruotis();
        }

        @Test
        public void MokiVeziPrisijungtiTest() {
            MokiVeziPrisijungti.prisijungti();
        }

        @Test
        public void MokiVeziIspardavimasTest() {
            MokiVeziIspardavimas.prekiuIspardavimas();
        }

        @BeforeClass
        public static void tearDown() {
            driver.quit();
        }

    }

