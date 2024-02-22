package herokuapp.TestCases;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetBooking {

	public static void main(String[] args) {
		Response response = given().log().uri().baseUri("https://restful-booker.herokuapp.com/").basePath("booking/{id}")
				.pathParam("id", 2).contentType(ContentType.JSON).when().get().then().extract().response();
		response.prettyPrint();
		if (response.statusCode() == 200) {
			System.out.println("Test Script Passed");
		} else {
			System.out.println("Test Script Failed");
		}
	}

}
