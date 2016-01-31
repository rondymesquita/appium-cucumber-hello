package br.com.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by rondymesquita on Aug 4, 2015
 *
 */
public class WebSteps {

	AndroidDriver<AndroidElement> driver;

	@Before("@web")
	public void before() throws MalformedURLException{
		driver = Driver.getDriver(DesiredCapabilitiesBuilder.Build());
		
	}
	
	@After("@web")
	public void after(){
		driver.quit();
    	System.out.println("Done!");
	}
	
	
	@Given("^I open \"(.*)\"$")
	public void iOpen(String url) throws Throwable{
		driver.navigate().to(url);
		System.out.println(url);
	}
	
	@And("^I enter \"(.*)\" in search field$")
	public void iEnter(String text) throws Throwable{
		WebElement searchField = driver.findElement(By.id("sb_form_q"));
		searchField.sendKeys(text);
		
	}
	
	@When("^I click on search button$")
	public void iClickOnSearchButton(){
		driver.findElement(By.id("sbBtn")).click();;
		
	}
	
	@Then("I should see on page \"(.*)\"$")
	public void i_should_see(String text) throws Throwable{
		driver.getPageSource().contains(text);
	}
	
}
