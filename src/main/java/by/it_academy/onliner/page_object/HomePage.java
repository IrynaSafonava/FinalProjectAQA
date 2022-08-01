package by.it_academy.onliner.page_object;

import by.it_academy.onliner.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private static final String HOME_PAGE_URL = "https://www.onliner.by";
    private static final String HEADER_NAVIGATION_LINK_PATTERN =
            "//*[@class='b-main-navigation__text' and text()='%s']";

    private static final String HEADER_NAVIGATION_SUBMENU =
            "//*[@class='b-main-navigation__dropdown b-main-navigation__dropdown_visible']";

    private static final String HEADER_NAVIGATION_SUBMENU_OPTIONS =
            "//div[contains(@class, 'dropdown_visible')]" +
                    "//span[@class='b-main-navigation__dropdown-advert-sign']";

    public void openOnlinerWebsite() {
        DriverManager.getDriver().get(HOME_PAGE_URL);
    }

    public void clickHeaderNavigationLink(String option) {
        waitForElementToBeVisible(By.xpath(String.format(HEADER_NAVIGATION_LINK_PATTERN, option))).click();
    }

    public void hoverHeaderCategoryLink(String category) {
        hoverElement(By.xpath(String.format(HEADER_NAVIGATION_LINK_PATTERN, category)));
    }

    public boolean isHeaderSubmenuOptionDisplayed() {
        return isElementDisplayed(By.xpath(HEADER_NAVIGATION_SUBMENU));
    }

    public List<WebElement> getListOfSubmenuOptions() {
        return getListOfElements(By.xpath(HEADER_NAVIGATION_SUBMENU_OPTIONS));
    }
}
