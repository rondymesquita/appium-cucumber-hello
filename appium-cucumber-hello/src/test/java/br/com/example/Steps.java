package br.com.example;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;

import net.masterthought.cucumber.ReportBuilder;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps{
	
	AndroidDriver<AndroidElement> driver;
	
	@Before("@device")
	public void before(){
		
	}
	
	@After("@device")
	public void after() throws Exception{
		
		List<String> jsonReportFiles = new ArrayList<String>();
		jsonReportFiles.add(RunCukesTest.REPORT_FOLDER+"/report.json");
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles, new File(RunCukesTest.REPORT_FOLDER),"", Calendar.getInstance().getTime().toString(), "cucumber-jvm", false, false, false, false, false, "", false);
    	reportBuilder.generateReports();
    	
    	driver.quit();
    	System.out.println("Done!");
    	
	}
	
	@Given("^I open AppTest$")
	public void i_open_app_test() throws Throwable{
		driver = Driver.getDriver(DesiredCapabilitiesBuilder.Build());
	}
	
	@When("^I fill name with \"(.*)\"$")
	public void i_fill_name_with(String name) throws Throwable{
		AndroidElement element = driver.findElementById("etName");
		element.sendKeys(name);
		
	}
	@When("^I fill music with \"(.*)\"")
	public void i_fill_music_with(String music) throws Throwable{
		AndroidElement element = driver.findElementById("etMusic");
		element.sendKeys(music);
	}
	
	@When("^I click on send button$")
	public void i_click_on() throws Throwable{
		AndroidElement element = driver.findElementById("btnSend");
		element.click();
	}
	
	@Then("I should see \"(.*)\"$")
	public void i_should_see(String text) throws Throwable{
//		String xpath = String.format("//TextView[@text=%s]", text);
//		driver.findElementByXPath(xpath);
//		Thread.sleep(1000);
		AndroidElement element = driver.findElementById("tvResult");
		Assert.assertEquals(text, element.getText());

		
	}
}
