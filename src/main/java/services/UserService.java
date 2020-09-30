package services;

import api.model.User;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;
import java.util.HashMap;
import java.util.Map;

public class UserService extends MethodsService { /* Crowdar Report Server */

/*    public static Response get(String jsonName) {
        return get(jsonName, Data.class);
    }

    public static Response post(String jsonName) {
        return post(jsonName, UserCreated.class);
    }
*/
    
    public static ThreadLocal<String> tlToken = new ThreadLocal<String>();

    public static Response get(String req) {
        Map<String, String> mapa = new HashMap<String, String>();
        mapa.put("token", "Bearer ".concat(tlToken.get()));

        return get(req, User.class, mapa);
    }
}
