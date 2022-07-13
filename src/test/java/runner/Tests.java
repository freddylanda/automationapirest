package runner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import base.Base;
import io.restassured.http.ContentType;

public class Tests extends Base{
		
	
	@Test
	public void addNePetTest() {
				given()
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "  \"id\": 1,\r\n"
						+ "  \"category\": {\r\n"
						+ "    \"id\": 1,\r\n"
						+ "    \"name\": \"CATEGORIA_CERO\"\r\n"
						+ "  },\r\n"
						+ "  \"name\": \"NOMBRE_PET\",\r\n"
						+ "  \"photoUrls\": [\r\n"
						+ "    \"URL_PET\"\r\n"
						+ "  ],\r\n"
						+ "  \"tags\": [\r\n"
						+ "    {\r\n"
						+ "      \"id\": 1,\r\n"
						+ "      \"name\": \"TAG_CERO\"\r\n"
						+ "    }\r\n"
						+ "  ],\r\n"
						+ "  \"status\": \"AVAILABLE\"\r\n"
						+ "}")
				.post("pet")
				.then()
				.statusCode(200);
	}
	
	@Test
	public void getPetTest() {
				given()
				.contentType(ContentType.JSON)
				.get("/pet/1")
				.then()
				.statusCode(200)
				.body("id", equalTo(1));
	}
	
	@Test
	public void updatePetTest() {
				String nameUpdate = given()
				.contentType(ContentType.JSON)
				.when()
				.body("{\r\n"
						+ "  \"id\": 1,\r\n"
						+ "  \"category\": {\r\n"
						+ "    \"id\": 1,\r\n"
						+ "    \"name\": \"CATEGORIA_CERO\"\r\n"
						+ "  },\r\n"
						+ "  \"name\": \"NUEVO_NOMBRE_PET\",\r\n"
						+ "  \"photoUrls\": [\r\n"
						+ "    \"NUEVA_URL_PET\"\r\n"
						+ "  ],\r\n"
						+ "  \"tags\": [\r\n"
						+ "    {\r\n"
						+ "      \"id\": 1,\r\n"
						+ "      \"name\": \"TAG_CERO\"\r\n"
						+ "    }\r\n"
						+ "  ],\r\n"
						+ "  \"status\": \"AVAILABLE\"\r\n"
						+ "}")
				.post("pet")
				.then()
				.statusCode(200)
				.extract()
				.jsonPath()
				.getString("name");
				
				assertThat(nameUpdate, equalTo("NUEVO_NOMBRE_PET"));
	}
	
	@Test
	public void getPetUpdateTest() {
				given()
				.contentType(ContentType.JSON)
				.get("/pet/1")
				.then()
				.statusCode(200)
				.body("id", equalTo(1));
	}
}
