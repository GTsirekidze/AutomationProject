package Steps;

import Results.TokenResults;
import Results.UserResults;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateUserSteps {

    public static UserResults createAccount( String username, Object password) {
        RequestSpecification requestSpecification = RestAssured.given();
        ResponseBody<Response> responseBody = requestSpecification.contentType(ContentType.JSON)
                .body(username, (ObjectMapper) password)
                .when()
                .post("https://bookstore.toolsqa.com/Account/v1/User");

        return responseBody.as(UserResults.class);
    }

    public static TokenResults tokenGeneration( String username, Object password) {
        RequestSpecification requestSpecification = RestAssured.given();
        ResponseBody<Response> responseBody = requestSpecification.contentType(ContentType.JSON)
                .body(username, (ObjectMapper) password)
                .when()
                .post("https://bookstore.toolsqa.com/Account/v1/GenerateToken");

        return responseBody.as(TokenResults.class);
    }

    public static boolean checkAuthorization( String username, Object password) {
        RequestSpecification requestSpecification = RestAssured.given();

        return requestSpecification.contentType(ContentType.JSON)
                .body(username, (ObjectMapper) password)
                .when()
                .post("https://bookstore.toolsqa.com/Account/v1/Authorized")
                .then()
                .extract()
                .response()
                .as(Boolean.class);
    }
}
