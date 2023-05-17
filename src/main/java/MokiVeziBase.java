import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MokiVeziBase {

   protected static WebDriver driver;



   public MokiVeziBase(WebDriver driver) {
      MokiVeziBase.driver = driver;
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }
         public static void goTo () {
         driver.get("https://mokivezi.lt");

      }
      protected void MokiVeziBase(){

      }
   }

