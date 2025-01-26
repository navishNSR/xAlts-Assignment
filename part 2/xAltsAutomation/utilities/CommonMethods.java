package xAltsAutomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import xAltsAutomation.config.DriverManager;

import java.time.Duration;

public class CommonMethods {

    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(DriverManager.driver);
        actions.scrollToElement(element).perform();
    }

    public String selectValueFromDropdownByVisibleText(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);
        return option;
    }

    public void waitUntilElementLoaded(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
