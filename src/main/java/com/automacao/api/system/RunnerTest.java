package com.automacao.api.system;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:Reporter/reporter.html"},
        features = {"features"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"com.automacao.api.steps"}

)
public class RunnerTest {
}
