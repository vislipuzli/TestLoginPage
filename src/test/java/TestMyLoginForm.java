import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestMyLoginForm extends TestPages {

    int count;

    TestMyLoginForm(int count){
        this.count = count;
        inputLogin();
    }

    private void inputLogin() {

        while (count > 0) {
            User user = new User();
            user.setPassword();
            user.setLogin();

            if (driver.getTitle().equals("Sign in")) {
                SetFields setFields = new SetFields(user.getLogin(), user.getPassword());
            }
            if (driver.getTitle().equals("Welcome")){
                WebElement logoutButton = driver.findElement(By.id("logoutForm"));
                logoutButton.click();
            }
            if (driver.getPageSource().contains("You have been logged out.")){
                SetFields loginSucesfulUser = new SetFields(user.getLogin(), user.getPassword());
            }
            this.count--;
            System.out.println(count);
        }
    }
}
