package api.config;

import services.*;

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

    PROJECTS { /* Crowdar Report Server */
        @Override
        public Class<?> getEntityService() { return ProjectsService.class; }
    },

    USERME { /* Crowdar Report Server */
        @Override
        public Class<?> getEntityService() { return UserMeService.class; }
    },

    AUTHENTICATE { /* Crowdar Report Server */
        @Override
        public Class<?> getEntityService() { return AuthenticateService.class; }
    };

    public abstract Class<?> getEntityService();
}
