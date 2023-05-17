import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class MokiVeziIspardavimas extends MokiVeziBase {

        private static final By Parduotuve = By.cssSelector("body > header > div.header-category-container.mt-4 > div > div > " +
                "nav > div.col-9.header-categories__side.header-categories__side--left > div.header-categories__link.header-" +
                "categories__link--category.link-unstyled.d-inline-block.cursor-pointer.noselect");
        private static final By Ispardavimas = By.xpath("//*[@id=\"headingispardavimasdesktop\"]/a");
        private static final By VisiPasiulymai = By.cssSelector("#product-item-3708272");



        public MokiVeziIspardavimas(WebDriver driver) {
                super(driver);
        }

        public static void prekiuIspardavimas() {

                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                WebElement listas = wait.until(ExpectedConditions.visibilityOfElementLocated(Parduotuve));
                listas.click();

                WebElement ispardavimas = wait.until(ExpectedConditions.visibilityOfElementLocated(Ispardavimas));
                if (ispardavimas.isDisplayed()) {
                        ispardavimas.click();
                } else {
                        System.out.println("Elementas yra neaktyvus");
                }

                List<WebElement> pasiulymai1 = driver.findElements(VisiPasiulymai);
                System.out.println(pasiulymai1.size());
                for (WebElement tittle : pasiulymai1) {
                        String title = tittle.getText();
                        System.out.println(title);
                        WebElement pasiulymai = wait.until(ExpectedConditions.visibilityOfElementLocated(VisiPasiulymai));
                        System.out.println(1);
                        if (pasiulymai.isDisplayed()) {
                                pasiulymai.click();
                        } else {
                                System.out.println("Elementas yra neaktyvus");
                        }
                }
        }
}


