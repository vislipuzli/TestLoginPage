import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class TestPages {

    static WebDriver driver;
    static String url = "http://localhost:8080/login";

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.gecko.driver", "D:/driversHP/geckodriver.exe");
            driver = new FirefoxDriver();
            openPage(url);
            TestMyLoginForm testMyLoginForm = new TestMyLoginForm(10000);
        }catch (Exception e){
            System.out.println("resource not avalable");
        }
    }

    private static void openPage(String s){
        driver.get(s);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
