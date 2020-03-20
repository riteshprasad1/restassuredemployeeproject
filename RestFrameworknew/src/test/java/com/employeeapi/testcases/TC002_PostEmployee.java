package com.employeeapi.testcases;

import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC002_PostEmployee extends TestBase {

	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSalary();
	String empAge = RestUtils.empAge();
	
	@BeforeClass
	public void postEmployee() throws InterruptedException 
	{
		logger= LogManager.getLogger(TC002_PostEmployee.class);
		logger.info("*****Started TC002_PostEmployee******");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();//requestobject

		JSONObject json = new JSONObject();
		json.put("name", empName);
		json.put("salary", empSalary);
		json.put("age", empAge);

		httpRequest.header("Content-type","application/json");

		httpRequest.body(json.toJSONString());

		response = httpRequest.request(Method.POST,"/create"); 

		Thread.sleep(5000);
	}
	@Test
	void responseBody() {
		logger.info("****Verifing response body******");
		String responseBody = response.getBody().asString();
		logger.info("Response body is "+responseBody);
		Assert.assertEquals(responseBody!=null, true);
	}
	
	
}
