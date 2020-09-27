package ar.steps;
import api.config.EntityConfiguration;
import api.model.Data;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class CatAPISteps extends PageSteps {

    @When("^realizo una peticion '(.*)' a '(.*)' al endpoint de categorias '(.*)'$")
    public void ejecutarOperacion(String operacion, String entity, String request)
            throws IllegalAccessException,IllegalArgumentException,InvocationTargetException,NoSuchMethodException{
        EntityConfiguration.valueOf(entity).getEntityService().getMethod(operacion.toLowerCase(), String.class).invoke(request);
    }

    @Then("Obtengo status code '(.*)'")
    public void obtengoStatusCodeStatusCode(int codEsperado) {
        int statusCode = APIManager.getLastResponse().getStatusCode();
        Assert.assertEquals(statusCode, codEsperado);
    }

    @And("Los datos son correctos")
    public void losDatosSonCorrectos() { /*probar que no sea nula la respuesta*/
        Object obj = APIManager.getLastResponse().getResponse() ;
        if (obj==null) {
            System.out.println("Respuesta sin datos");
        }
    }
}
