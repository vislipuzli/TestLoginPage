import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewUser extends TestPages{

    NewUser(String login, String password){
        setFields(login, password);

        if (driver.getTitle().equals("Welcome")){
            WebElement logoutButton = driver.findElement(By.linkText("Logout"));
            logoutButton.click();
        }else {
            WebElement createButton = driver.findElement(By.linkText("Create an account"));
            createButton.click();
        }
    }

    private void setFields(String login, String password) {
        WebElement loginField = driver.findElement(By.id("username"));
        loginField.click();
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys(password);

        WebElement passwordConfirmField = driver.findElement(By.id("passwordConfirm"));
        passwordConfirmField.click();
        passwordConfirmField.sendKeys(password);

        driver.findElement(By.className("button")).click();
    }
}
