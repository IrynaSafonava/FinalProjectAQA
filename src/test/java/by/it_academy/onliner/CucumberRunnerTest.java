package by.it_academy.onliner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-htmlreport/CucumberRunnerTest",
                "json:target/json-files/CucumberRunnerTest.json",
                "junit:target/junit_cucumber.xml"},
        tags="smoke",
        glue = "by.it_academy.onliner",
        features = "classpath:features/"
)

public class CucumberRunnerTest {
}
