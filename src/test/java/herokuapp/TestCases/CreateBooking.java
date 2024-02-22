package herokuapp.TestCases;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateBooking {

	public static void main(String[] args) {
		//"bookingid": 1390
		// Build the request
		Response response = given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.body("{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				.contentType(ContentType.JSON).when().post().then().extract().response();

		// Validating the response
		response.prettyPrint();
		if (response.statusCode() == 200) {
			System.out.println("Test Script Passed");
		} else {
			System.out.println("Test Script Failed");
		}

	}

}
