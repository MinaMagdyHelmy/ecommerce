package org.example.testRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = "org.example.stepDefs",
        tags = "@smoke",
        plugin = {"pretty",   }


)


public class runner extends AbstractTestNGCucumberTests{
}
