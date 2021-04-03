package retrieveAllUsersAPI;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RetrieveAllUsersAPITest {
    private int size = 100;
    @Test
    public void RetrieveAllUsers(){
        baseURI="https://jsonplaceholder.typicode.com";
        given().
                contentType(ContentType.JSON).
                when().
                get("/posts").
                then().
                assertThat().
                statusCode(200).
                and().
                body("size()", is(size));
    }
}
