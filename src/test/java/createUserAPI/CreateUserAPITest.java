package createUserAPI;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserAPITest {
    private String title = "Foo";
    private String body = "bar";
    private int userId =  1;

    @Test(priority = 1)
    public void createUser(){
        JSONObject request = new JSONObject();
        request.put("title",title);
        request.put("body",body);
        request.put("userId",userId);
        baseURI="https://jsonplaceholder.typicode.com";

        given().
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/posts").
                then().
                assertThat().
                statusCode(201).
                body("title",equalTo(title)).
                body("body",equalTo(body)).
                body("userId",equalTo(userId)).
                body("id",equalTo(101));
    }

}
