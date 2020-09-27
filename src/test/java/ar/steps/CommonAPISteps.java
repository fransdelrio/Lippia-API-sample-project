package ar.steps;

import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CommonAPISteps extends PageSteps {

    @Then("Obtengo status code '(.*)'")
    public void obtengoStatusCode(int codEsperado) {
        int statusCode = APIManager.getLastResponse().getStatusCode();
        Assert.assertEquals(statusCode, codEsperado);   /* Compara StatusCode obtenido con el esperado */
    }

}
