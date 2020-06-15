package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/features/BigBasketSecondTC.feature"},
				 glue = "stepDefinitions",
				 snippets = SnippetType.CAMELCASE,
				 monochrome = true,
				 plugin = {"pretty","html:reports"})
public class RunBigBasket1 extends AbstractTestNGCucumberTests {

}
