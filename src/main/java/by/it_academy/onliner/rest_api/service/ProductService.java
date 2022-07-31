package by.it_academy.onliner.rest_api.service;

import by.it_academy.onliner.framework.PropertiesReader;
import by.it_academy.onliner.rest_api.model.Product;
import by.it_academy.onliner.rest_api.utils.GetRequestUtil;
import by.it_academy.onliner.rest_api.utils.ResponseBodyUtil;
import com.google.common.collect.ImmutableMap;
import io.restassured.response.ResponseBody;

import java.util.List;
import java.util.Map;

public class ProductService {

    private static final String SUSHI_JSON_PATH = "products";

    public List<Product> getProductsItems() {
        ResponseBody responseBody = GetRequestUtil
                .getResponseBody(PropertiesReader.getEndpointProperty("catalog.api.search.sushivesla"),
                        configureHeaders(), null);
        return ResponseBodyUtil
                .GetObjectsByJsonPath(responseBody, SUSHI_JSON_PATH, Product.class);
    }

    public static Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }
}
