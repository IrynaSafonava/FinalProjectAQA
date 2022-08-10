package by.it_academy.onliner.api_tests;

import by.it_academy.onliner.page_object.BasePage;
import by.it_academy.onliner.rest_api.model.Product;
import by.it_academy.onliner.rest_api.service.ProductService;
import jdk.jfr.Description;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsApiTest {

    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    @Test
    @Description("Product items from response contain not empty values")
    public void productValuesNotEmpty() {
        LOG.info("Executing test: Product items from response contain not empty values ");

        List<Product> productList = new ProductService().getProductsItems();
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(productList)
                .as("ID is not null").extracting(Product::getId).isNotNull();
        softly.assertThat(productList)
                .as("Full_name is not null").extracting(Product::getFull_name).isNotEmpty();
        softly.assertThat(productList)
                .as("Name is not null").extracting(Product::getName).isNotEmpty();
        softly.assertThat(productList)
                .as("Key is not null").extracting(Product::getKey).isNotEmpty();
        softly.assertAll();
        LOG.info("Stop test executing");
    }
    @Test
    @Description("Product items from response contain required filter option prefix")
    public void responseContainsFilterOption(){
        LOG.info("Executing test: Product items from response contain required filter option prefix");
        List<String> productFilterOptions = new ProductService().getProductFilterOptions();

        assertThat(productFilterOptions)
                .as("Response contains filter option")
                .allMatch(option -> option.equals("Роллы"));
        LOG.info("Stop test executing");
    }
}
