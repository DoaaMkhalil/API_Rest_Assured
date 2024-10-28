import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization {
    @DataProvider
    public static Object[][] testDate()
    {
        return new Object[][]{
                {"us","90210","Beverly Hills"},
                {"us","12345","schenectady"},
                {"ca","B2R","Waverley"}

        };
    }
    @Test(dataProvider = "testDate")
    public void testResBody(String country ,String zip , String place)
    {
        given().pathParam("country",country).pathParam("postalCode",zip)
                .when().get("http://api.zippopotam.us/{country}/{postalCode}").then()
                .assertThat().
                body("places[0].'place name'",equalTo(place));
    }
}
