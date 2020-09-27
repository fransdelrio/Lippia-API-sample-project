package services;

import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;

public class AuthenticateService extends MethodsService {   /* Crowdar Report Server */
    public static Response post(String req) {
        return post(req, String.class);
    }
}
