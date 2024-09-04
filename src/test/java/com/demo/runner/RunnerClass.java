package com.demo.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(features="src/test/resources/features/",glue= {"com.demo.steps"},
plugin= {"pretty","html:target/cucumberReport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})//
public class RunnerClass  extends AbstractTestNGCucumberTests
{

}
