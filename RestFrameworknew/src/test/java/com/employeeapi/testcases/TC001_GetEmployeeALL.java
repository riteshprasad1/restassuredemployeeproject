package com.employeeapi.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC001_GetEmployeeALL extends TestBase {
	

	
	 @BeforeClass
	 public void getEmployees() throws IOException, InterruptedException
	 { 
		 logger= LogManager.getLogger(TC001_GetEmployeeALL.class);
		 logger.info("*****Started TC001_GetEmployeeALL******");
		 RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		 httpRequest = RestAssured.given();//requestobject
		 response = httpRequest.request(Method.GET,"/employees");
		 
		 Thread.sleep(5000);
		 
	 }
	 @Test
	 void checkResponseBody()
	 {
		 logger.info("Verifying response body");
		 String  responseBody = response.getBody().asString();
		 
		 logger.info("Response Body " +responseBody);
		 Assert.assertTrue(responseBody!=null);
		 
	 }
		// System.out.println("Response body is"+responseBody); //status code 
		
		 
	/*
	 * }int statuscode = response.getStatusCode();
	 * System.out.println("Status code is "+statuscode);
	 * Assert.assertEquals(statuscode, 200); String statusline =
	 * response.getStatusLine(); System.out.println("Status line is "+statusline); }
	 */
}
