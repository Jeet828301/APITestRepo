package herokuapp.TestCases;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartialUpdateBooking {

	public static void main(String[] args) {
		String token = CreateToken.getAccessToken();
		System.out.println("Token : " + token);
		Response response = given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking/{id}")
				.pathParam("id", 2).header("Cookie", "token=" + token)
				.body("{\r\n" + "    \"firstname\" : \"Priojit\",\r\n" + "    \"lastname\" : \"Sen\"\r\n" + "}")
				.contentType(ContentType.JSON).when().patch().then().extract().response();
		response.prettyPrint();
		System.out.println(response.statusCode());
		if (response.statusCode() == 200) {
			System.out.println("Test Script Passed");
		} else {
			System.out.println("Test Script Failed");
		}
	}

}
