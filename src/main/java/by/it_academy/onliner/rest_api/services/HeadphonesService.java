package by.it_academy.onliner.rest_api.services;

import by.it_academy.onliner.rest_api.model.Headphones;
import by.it_academy.onliner.rest_api.utils.GetRequestUtil;
import by.it_academy.onliner.rest_api.utils.ResponseBodyUtil;
import com.google.common.collect.ImmutableMap;
import io.restassured.response.ResponseBody;
import java.util.List;
import java.util.Map;

public class HeadphonesService {

    private static final String HEADPHONES_JSON_PATH = "facets.general.items";

    public List<Headphones> getHeadphonesItems(){
        ResponseBody responseBody = GetRequestUtil
                .getResponseBody("URL_ENDPOINT", configureHeaders(), null);
        return ResponseBodyUtil
                .GetObjectsByJsonPath(responseBody, HEADPHONES_JSON_PATH, Headphones.class);
    }

    public static Map<String, Object> configureHeaders(){
        return ImmutableMap.of("Host", "catalog.onliner.by");

    }
}
