package com.thinktimetechno.hooks.endpoints;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.apache.http.entity.mime.HttpMultipartMode;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class postExample extends BaseEndpoints {


	String token;
	RequestSpecification requestSpecification;
	public Response result;
	private String application_ENDPOINT_PATH = "";

	public Response applicationSalesCreatePayload(String jsonFile) throws IOException {
		token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyNDA2OSIsImFjdGlvbiI6ImF1dGgiLCJ0b2tlbi12ZXJzaW9uIjowLCJpYXQiOjE2OTczNDY2MTYsImV4cCI6MTY5NzQzMzAxNn0.zBfC1JCqk41rn2ugBQOk4MsHySZfbdPwJ7bS9dbmR_M";

		File pdfData= new File(System.getProperty("user.dir")+"/src/test/resources/Payloads/sample.pdf");
		//File imageData = new File(System.getProperty("user.dir") + "/src/test/resources/Payloads/download.jpg");
		File jsonDataforPDF= new File(System.getProperty("user.dir")+"/src/test/resources/Payloads/Auth.json");



		switch (jsonFile) {
			case "applicationSalesFilters":
				application_ENDPOINT_PATH = "/admission/api/admission-service/pre-admissions/2925/5/uploadImages";

				result = given()
						.header("Authorization", "Bearer " + token)
						.multiPart("documentRequest", jsonDataforPDF, "application/json")
						.multiPart("file", pdfData, "application/pdf")
						.when().post(getBaseUrl() + application_ENDPOINT_PATH);
				break;

		}
		return result;
	}
}



