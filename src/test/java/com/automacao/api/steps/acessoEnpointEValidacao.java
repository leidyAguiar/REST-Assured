package com.automacao.api.steps;

import com.automacao.api.components.components;
import io.cucumber.java.en.*;

public class acessoEnpointEValidacao {

    components component;

    @Given("que seja acessado API {string}")
    public void queSejaAcessadoAPI(String url) {
        component = new components(url);
        component.endpointReturn();
    }

    @When("for validado o valor do campo name que seja igual a {string}")
    public void forValidadoOValorDoCampoNameQueSejaIgualA(String value)  {
        component.validationPath("data.first_name", value);
    }
    @Then("efetuado o teste de contrato ou schema")
    public void efetuadoOTesteDeContratoOuSchema() {
        component.validationSchema();
    }
}
