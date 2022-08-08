package by.it_academy.onliner.page_object;

import by.it_academy.onliner.parallel_local.WebDriverFactoryStaticThreadLocal;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(WebDriverFactoryStaticThreadLocal.getDriver(), this);
    }

    public WebElement waitForElementToBeVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(WebDriverFactoryStaticThreadLocal.getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> getListOfElements(By by) {
        return WebDriverFactoryStaticThreadLocal.getDriver().findElements(by);
    }

    public void hoverElement(By by) {
        WebElement element = waitForElementToBeVisible(by);
        Actions action = new Actions(WebDriverFactoryStaticThreadLocal.getDriver());
        action.moveToElement(element).perform();
    }

    public boolean isElementDisplayed(By by) {
        try {
            return waitForElementToBeVisible(by)
                    .isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
