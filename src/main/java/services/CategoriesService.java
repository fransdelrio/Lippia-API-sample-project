package services;

import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;

public class CategoriesService extends MethodsService{
    public static Response get(String jsonName) {
        return get(jsonName, String.class);
    }
}
