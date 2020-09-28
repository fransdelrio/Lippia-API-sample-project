package ar.steps;

import api.config.EntityConfiguration;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import cucumber.api.java8.En;
import io.cucumber.java.en.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import java.lang.reflect.InvocationTargetException;
/*
 * CRS: siglas para Crowdar Report Server
 */

public class CRS_Steps extends PageSteps {

    @When("^realizo una peticion '(.*)' a '(.*)' al endpoint de autenticacion '(.*)'$")
    public void ejecutarOperacion(String operacion, String entity, String request)
            throws IllegalAccessException,IllegalArgumentException, InvocationTargetException,NoSuchMethodException{
        EntityConfiguration.valueOf(entity).getEntityService().getMethod(operacion.toLowerCase(), String.class).invoke("", request);
    }

    @And("Obtengo un token")
    public String obtengoUnToken() {
        String response = (String) APIManager.getLastResponse().getResponse();
        //System.out.println("\nRespuesta: \n\n" + response + "\n");
        JSONObject jsonResponse = null;
        try {
            jsonResponse = new JSONObject(response);
            //System.out.println("\njsonResponse: \n\n" + jsonResponse + "\n");
        }catch (JSONException err){
            System.out.println("\nError: "+ err.toString() + "\n");
        }
        //System.out.println("\nToken JWT obtenido: " + jsonResponse.get("jwt").toString() + "\n");
        int jwtCrowdarLength = 212;
        //System.out.println("\njwtCrowdarLength: " + jwtCrowdarLength + "\n");
        //Assert.assertEquals(jwtCrowdarLength, jsonResponse.get("jwt").toString().length());
        return  jsonResponse.get("jwt").toString();
    }

}
