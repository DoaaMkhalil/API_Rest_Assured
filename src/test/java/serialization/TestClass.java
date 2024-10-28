package serialization;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestClass {
    @Test
    public void testDe(){
        Location location =
                given().when().get("http://api.zippopotam.us/us/90210").
                        as(Location.class);
        Assert.assertEquals(location.getPlaces().get(0).getPlaceName(),"Beverly Hills");
    }
    @Test
    public void testSe(){
        Location location =new Location();
        // location.setCountry("");
        given().contentType(ContentType.JSON).body(location).log().body().when()
                .post("http://api.zippopotam.us/us/90210")
                .then().assertThat().statusCode(200);
        /*test*/
    }
}
