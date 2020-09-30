package ar.steps;

import api.config.EntityConfiguration;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import cucumber.api.java8.En;
import io.cucumber.java.en.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import services.ProjectsService;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
/*
 * CRS: siglas para Crowdar Report Server
 */

public class CRS_Steps extends PageSteps {

    @When("^realizo una peticion '(.*)' a '(.*)' al endpoint '(.*)'$")
    public void ejecutarOperacion(String operacion, String entity, String request)
            throws IllegalAccessException,IllegalArgumentException, InvocationTargetException,NoSuchMethodException{
        EntityConfiguration.valueOf(entity).getEntityService().getMethod(operacion.toLowerCase(), String.class).invoke("", request);
    }

    @And("Obtengo un token")
    public String obtengoUnToken() throws FileNotFoundException {
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
        //int jwtCrowdarLength = 212;
        //System.out.println("\njwtCrowdarLength: " + jwtCrowdarLength + "\n");
        //Assert.assertEquals(jwtCrowdarLength, jsonResponse.get("jwt").toString().length());

        /* Está mal pero no tan mal??? */
        //File file = new File("D:\\Crowdar\\Lippia-API-sample-project\\src\\test\\resources\\jsons\\request\\rq_crs_projectsq.json");
        //String regex = "[A-Za-z0-9\\-\\._~\\+\\/]+=*";
        //              ^[A-Za-z0-9-_=]+\.[A-Za-z0-9-_=]+\.?[A-Za-z0-9-_.+/=]*$
        //String regex = "^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$"; // ^[A-Za-z0-9-_=]+\.[A-Za-z0-9-_=]+\.?[A-Za-z0-9-_.+/=]*$
        //String toReplace = jsonResponse.get("jwt").toString();

        //FileReader fr = new FileReader(file);
        //String s;
        //String totalStr = "";
        //try {
        //    BufferedReader br = new BufferedReader(fr);

        //    while ((s = br.readLine()) != null) {
        //        totalStr += s;
        //    }
        //    totalStr = totalStr.replaceAll(regex, toReplace); //reemplazo de token en json
        //    FileWriter fw = new FileWriter(file);
        //    fw.write(totalStr);
        //    fw.close();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        String jwtToken = jsonResponse.get("jwt").toString();
        System.out.println("\nToken JWT obtenido: " + jsonResponse.get("jwt").toString() + "\n");
        ProjectsService.tlToken.set(jwtToken);
        return jwtToken;
    }

}
