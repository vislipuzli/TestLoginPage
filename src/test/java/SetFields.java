import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SetFields extends TestPages{

    private String login;
    private String password;

    SetFields(String login, String password){
        this.login = login;
        this.password = password;

        inputLoginField();
        inputPasswordField();
        signing();

        if (driver.getTitle().equals("Welcome")){
            System.out.println("Sucessful");
        }
    }

    private void signing() {
        driver.findElement(By.className("button")).click();
        if (driver.getTitle().equals("Welcome")){
            WebElement logoutButton = driver.findElement(By.linkText("Logout"));
            logoutButton.click();
        }else {
            WebElement createButton = driver.findElement(By.linkText("Create an account"));
            createButton.click();
            createAccount();
        }
    }

    private void createAccount() {
        if (driver.getTitle().equals("Create an account")){
            NewUser newUser = new NewUser(this.login, this.password);
        }else {
            signing();
        }
    }

    private void inputPasswordField() {
        WebElement loginField = driver.findElement(By.name("password"));
        loginField.click();
        loginField.sendKeys(this.password);
        System.out.println("Password is: " + password);
    }

    private void inputLoginField() {
        WebElement loginField = driver.findElement(By.name("username"));
        loginField.click();
        loginField.sendKeys(this.login);
        System.out.println("Login is: " + login);
    }
}
