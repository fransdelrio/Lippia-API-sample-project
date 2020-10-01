package services;

import api.model.UserMe;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;
import java.util.HashMap;
import java.util.Map;

public class UserMeService extends MethodsService { /* Crowdar Report Server */
//    public static ThreadLocal<String> tlToken = new ThreadLocal<String>();

    public static Response get(String req) {
        Map<String, String> mapa = new HashMap<String, String>();
        mapa.put("token", "Bearer ".concat(GenericService.tlToken.get()));
        return get(req, UserMe.class, mapa);
    }
}
