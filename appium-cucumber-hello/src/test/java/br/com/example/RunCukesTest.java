package br.com.example;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { 
		"pretty",
		"html:build/reports/report",
		"json:build/reports/report.json"
		})
public class RunCukesTest {
	
	public final static String REPORT_FOLDER = "./build/reports"; 
	
}
