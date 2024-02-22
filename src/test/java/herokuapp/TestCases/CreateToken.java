package herokuapp.TestCases;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateToken {
	public static String getAccessToken() {
		Response response = given().baseUri("https://restful-booker.herokuapp.com/").basePath("auth")
				.body("{\r\n" + "    \"username\" : \"admin\",\r\n" + "    \"password\" : \"password123\"\r\n" + "}")
				.contentType(ContentType.JSON).when().post().then().extract().response();

		return String.valueOf(response.path("token").toString());

	}
}
