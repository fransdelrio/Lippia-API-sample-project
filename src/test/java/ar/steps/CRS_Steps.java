package ar.steps;

import api.config.EntityConfiguration;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.google.gson.JsonObject;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import io.cucumber.java.en.And;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;

public class CRS_Steps extends PageSteps {

    @io.cucumber.java.en.When("^realizo una peticion '(.*)' a '(.*)' al endpoint de autenticacion '(.*)'$")
    public void ejecutarOperacion(String operacion, String entity, String request)
            throws IllegalAccessException,IllegalArgumentException, InvocationTargetException,NoSuchMethodException{
        EntityConfiguration.valueOf(entity).getEntityService().getMethod(operacion.toLowerCase(), String.class).invoke("", request);
    }

    @And("Obtengo un token")
    public String obtengoUnToken() {
        JsonObject jsonResponse = (JsonObject) APIManager.getLastResponse().getResponse();
        System.out.println("\nRespuesta: \n\n" + jsonResponse + "\n");
        return  jsonResponse.get("jwt").getAsString();
    }
}
