package api.config;

import services.AuthenticateService;
import services.CategoriesService;
import services.ResponseHeadersService;
import services.UserService;

public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }
    },
    RESPONSE_HEADERS {
        @Override
        public Class<?> getEntityService() {
            return ResponseHeadersService.class;
        }
    },

    CATEGORIES {
        @Override
        public Class<?> getEntityService() { return CategoriesService.class; }
    },

    AUTHENTICATE { /* Crowdar Report Server */
        @Override
        public Class<?> getEntityService() { return AuthenticateService.class; }
    };

    public abstract Class<?> getEntityService();
}
