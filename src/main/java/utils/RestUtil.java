package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.*;


/**
 * Created by john on 2017/6/19.
 */
public class RestUtil {

    private static RequestSpecification spec;
    private static String path;
    private static RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();


    public static void setBaseURI(String baseURI) {
        requestSpecBuilder.setBaseUri(baseURI);
    }

    public static void setBasePath(String basePath) {
        requestSpecBuilder.setBasePath(basePath);
    }


    public static void setContentType(ContentType type) {
        requestSpecBuilder.setContentType(type);
    }

    public static void setLogAll() {
        requestSpecBuilder.addFilter(new ResponseLoggingFilter());
        requestSpecBuilder.addFilter(new RequestLoggingFilter());
    }

    public static void setLogRequest() {
        requestSpecBuilder.addFilter(new RequestLoggingFilter());
    }

    public static void setLogResponse() {
        requestSpecBuilder.addFilter(new ResponseLoggingFilter());
    }

    public static void setHeader(String headerName, String headerValue) {
        requestSpecBuilder.addHeader(headerName, headerValue);
    }

    public static void setHeaders(Map<String, String> headers) {
        requestSpecBuilder.addHeaders(headers);
    }

    public static void build() {
        spec = requestSpecBuilder.build();
    }


    public static void createQueryPath(String searchTerm, String jsonPathTerm, String param, String paramValue) {
        path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
    }

    public static Response getResponse() {
        if (Objects.isNull(path)) {
            return given().spec(spec).get();
        }

        return given().spec(spec).get(path);
    }


    public static Response postResponse() {

        return null;
    }

    public static JsonPath getJsonPath(Response response) {
        String json = response.asString();
        return new JsonPath(json);
    }
}
