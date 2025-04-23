package com.sa.spring_tuto_web.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class }; // global beans (DataSource, Services, Security, etc)
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class }; // MVC config (ViewResolvers, Controllers, etc)
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
