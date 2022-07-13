package base;

import org.junit.Before;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class Base {

	@Before
	public void setUp() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		RestAssured.basePath = "/v2";
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		
		RestAssured.requestSpecification = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.build();
	}
}
