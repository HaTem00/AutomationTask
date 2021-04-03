package retrieveSpecificUserAPI;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RetrieveSpecificUserAPITest {
    private String validId = "35";
    private String invalidId = "500";

    @Test(priority = 1)
    public void getUserByIdSuccessfully(){
        baseURI="https://jsonplaceholder.typicode.com";
        given().
                contentType(ContentType.JSON).
                pathParam("id",validId).
                when().
                get("/posts/{id}").
                then().
                assertThat().
                statusCode(200)
                .body("id",equalTo(35))
                .body("userId",equalTo(4))
                .body("title",equalTo("id nihil consequatur molestias animi provident"));
    }

    @Test(priority = 2)
    public void getUserByIdFailure(){
        baseURI="https://jsonplaceholder.typicode.com";
        given().
                contentType(ContentType.JSON).
                pathParam("id",invalidId).
                when().
                get("/posts/{id}").
                then().
                assertThat().
                statusCode(404);
    }
}
