package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions( features = {"src/test/java/features/Carwale.feature"},
				  glue = "stepDefinitions",
				  snippets = SnippetType.CAMELCASE,
				  monochrome = true,
				  plugin = {"html:reports"}
		
				)
public class RunCarWale extends AbstractTestNGCucumberTests{

}
