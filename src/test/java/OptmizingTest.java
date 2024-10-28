import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class OptmizingTest {
    RequestSpecification requestSpecification ;
    ResponseSpecification responseSpec ;
    @BeforeTest
    public void reqBase(){
        requestSpecification =new RequestSpecBuilder().
                setBaseUri("https://zippopotam.us/").build();
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }
    @Test
    public void testResBody()
    {
        given().when().spec(requestSpecification).when().get("us/90210").then().spec(responseSpec)
                .and().assertThat().
                body("places[0].'place name'",equalTo("Beverly Hills"));

    }

    @Test
    public void extractRes(){
     String place =   given().when().spec(requestSpecification).
             get("us/90210").then().extract().path("places[0].'place name'");
        Assert.assertEquals(place,"Beverly Hills");

    }

}
