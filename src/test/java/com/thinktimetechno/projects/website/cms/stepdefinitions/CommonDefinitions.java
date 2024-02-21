package com.thinktimetechno.projects.website.cms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.thinktimetechno.hooks.endpoints.BaseEndpoints;

public class CommonDefinitions {
	
	private World world;
	private BaseEndpoints be = new BaseEndpoints();

	@Given("^the Applicationsale API is available$")

	public void the_swagger_petstore_api_is_available() {
		String url = be.getBaseUrl();
	}
	
	@Then("^the requests response will contain the value '(.*?)' for the '(.*?)' field$")
	public void i_will_be_able_to_run_connected_step_definitions(String val, String key) {
		be.verifyResponseKeyValues(key, val, world.getResponse());
	}

}
