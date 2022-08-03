package by.it_academy.onliner;

import by.it_academy.onliner.rest_api.model.Product;
import by.it_academy.onliner.rest_api.service.ProductService;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsApiTest {
    @Test
    @Description("Product items from response contain not empty values")
    public void productValuesNotEmpty() {
        List<Product> productList = new ProductService().getProductsItems();

        productList.forEach(product -> {
            assertThat(product.getId()).as("ID of " + product + " is not null")
                    .isNotNull();
            assertThat(product.getFull_name()).as("Full_name of " + product + " is not null")
                    .isNotEmpty();
            assertThat(product.getName()).as("Name of " + product + " is not null")
                    .isNotEmpty();
            assertThat(product.getKey()).as("Key of " + product + " is not null")
                    .isNotEmpty();
        });
    }
    @Test
    @Description("Product items from response contain required filter option prefix")
    public void responseContainsFilterOption(){

        List<String> productFilterOptions = new ProductService().getProductFilterOptions();
        productFilterOptions.forEach(element -> assertThat(element.equals("Роллы"))
                .as("Response contains filter option")
                .isTrue());
    }
}
