import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest {
    @Test
    public void testResBody()
    {
        given().when().get("http://api.zippopotam.us/us/90210").then()
                .assertThat().
                // expression representing the expected value
                body("country",equalTo("United States")).
                body("places[0].'place name'",equalTo("Beverly Hills")).
                body("places[0].'state'",equalTo("California"));
    }
    @Test
    public void testBodyContainExactValue()
    {
        given().when().get("http://api.zippopotam.us/us/90210").then()
                .assertThat().

                body("places.'place name'",hasItem("Beverly Hills"));
    }
    @Test
    public void testSizeOfBodyList()
    {
        given().when().get("http://api.zippopotam.us/us/90210").then()
                .assertThat().

                body("places.'place name'",hasSize(1));
    }
    @Test
    public void testStatusCode()
    {
        given().when().get("http://api.zippopotam.us/us/90210").then()
                .assertThat().
                statusCode(200);
    }


    @Test
    public void testResponseContentType()
    {
        given().when().get("http://api.zippopotam.us/us/90210").then()
                .assertThat().
                contentType(ContentType.JSON /*  ==>  "application/json*/);
    }

    @Test
    public void dealingWithREQAndResDetails()
    {
        // for request logs
given().log().all().when().get("http://api.zippopotam.us/us/90210")
      // for response logs
        .then().log().all();
    }



    @Test
    public void checkResBody()
    {
        // for request logs
        given().log().all().when().get("http://api.zippopotam.us/us/90210")
                // for response logs
                .then().log().all();
    }

}
