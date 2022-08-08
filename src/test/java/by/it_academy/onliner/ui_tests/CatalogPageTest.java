package by.it_academy.onliner.ui_tests;

import by.it_academy.onliner.driver.DriverManager;
import by.it_academy.onliner.page_object.CatalogPage;
import by.it_academy.onliner.page_object.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogPageTest {
    private static CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void navigateToCatalogFromOnlinerHomePage() {
        DriverManager.startBrowser();
        HomePage homepage = new HomePage();
        homepage.openOnlinerWebsite();
        homepage.clickHeaderNavigationLink("Каталог");
    }

    @ParameterizedTest(name = "#{index} - Run test with option = {0}")
    @ValueSource(strings = {"Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт",
            "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис"})
    public void catalogClassifierOptionsDisplayed(String option) {
        boolean isCatalogNavigationOptionDisplayed = catalogPage
                .isClassifierDisplayed(option);

        assertThat(isCatalogNavigationOptionDisplayed)
                .as("Classifier " + option + " is in catalog navigation list")
                .isTrue();
    }

    @Test
    public void sideListWithCategoriesDisplayed() {
        boolean isSideListDisplayed = catalogPage
                .clickCatalogClassifierLink("Компьютеры и сети").isSideListDisplayed();

        if (!isSideListDisplayed) {
            isSideListDisplayed = catalogPage
                    .clickCatalogClassifierLink("Компьютеры и сети").isSideListDisplayed();
        }

        List<WebElement> listOfCategories = catalogPage.getListOfCategories();

        assertThat(isSideListDisplayed)
                .as("Side list is displayed")
                .isTrue();

        assertThat(listOfCategories)
                .as("All categories present in the side list")
                .extracting(WebElement::getText)
                .containsAll(Arrays.asList("Ноутбуки, компьютеры, мониторы", "Комплектующие",
                        "Хранение данных", "Сетевое оборудование"));
    }

    @ParameterizedTest(name = "#{index} - Run test with classifier = {0} and category = {1}")
    @CsvSource(value = {"Компьютеры и сети, Комплектующие"})
    public void allCategoryItemsHaveTitleAndFullDescription(String classifier, String category) {

        catalogPage.clickCategoryLinkIfClassifierActive(classifier, category);

        int categoryItemsNumber = catalogPage
                .getListOfCategoryItems(category)
                .size();

        List<WebElement> listOfItemsWithTitles = catalogPage
                .getListOfTitles(category);
        System.out.println(listOfItemsWithTitles);
        List<WebElement> listOfItemsDescriptionsWithProductQnt = catalogPage
                .getListOfDescriptionsWithContent("товар");
        List<WebElement> listOfItemsDescriptionsWithPrice = catalogPage
                .getListOfDescriptionsWithContent("р.");

        assertThat(listOfItemsWithTitles)
                .as("Category items have no empty titles")
                .hasSize(categoryItemsNumber)
                .noneMatch(title -> title.getText().isEmpty());

        assertThat(listOfItemsDescriptionsWithPrice)
                .as("Category items have min price")
                .hasSize(categoryItemsNumber);

        assertThat(listOfItemsDescriptionsWithProductQnt)
                .as("Category items have quantity")
                .hasSize(categoryItemsNumber);
    }

    @AfterAll
    public static void close() {
        catalogPage.closeBrowser();
    }
}
