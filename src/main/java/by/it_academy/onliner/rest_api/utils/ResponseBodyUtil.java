package by.it_academy.onliner.rest_api.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseBodyUtil {

    public static <T> T GetObjectByJsonPath(ResponseBody responseBody,
                                            String jsonPath, Class<T> type) {
        return responseBody
                .jsonPath()
                .getObject(jsonPath, type);
    }

    public static <T> List<T> GetObjectsByJsonPath(ResponseBody responseBody,
                                                   String jsonPath, Class<T> type) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, type);
    }

    public static String getStringJsonValue(ResponseBody responseBody, String jsonPath) {
        System.out.println(responseBody);
        return JsonPath.from(responseBody.asString()).getString(jsonPath);
    }

}
