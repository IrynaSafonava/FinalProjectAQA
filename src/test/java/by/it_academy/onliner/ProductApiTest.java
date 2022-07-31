package by.it_academy.onliner;

import by.it_academy.onliner.rest_api.model.Product;
import by.it_academy.onliner.rest_api.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductApiTest {
    @Test
    public void productValuesNotEmpty(){
        List<Product> productList = new ProductService().getProductsItems();
        System.out.println(productList);
    }

}
