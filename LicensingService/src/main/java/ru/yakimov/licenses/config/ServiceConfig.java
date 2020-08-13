package ru.yakimov.licenses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {

    @Value("${tracer.property}")
    private String exampleProperty;

    public String getExampleProperty(){
        return exampleProperty;
    }

}
