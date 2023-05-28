package sharedfunctions;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import requestRepositoryPackage.Post_req_repository;

public class ApiSharedFunctions {
	
	public static int response_statusCode(String baseURI,String resource,String requestbody) {
		RestAssured.baseURI=baseURI;
		 
		int statusCode=given().header("Content-Type","application/json").body(requestbody).
						when().post(resource).
						then().extract().statusCode();
		return statusCode;
	}
	public static String response_body(String baseURI,String resource,String requestbody) {
		RestAssured.baseURI=baseURI;
		 
      String responsebody = given().header("content-Type", "application/json").body(requestbody).
   		   				when().post(resource).
   		   				then().extract().response().asString();
      return responsebody;
	
	
	}

}
