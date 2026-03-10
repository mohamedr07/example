package com.example.microservices.catalog.web.autoconfig;

import com.broadleafcommerce.catalog.web.autoconfigure.CatalogWebAutoConfiguration;
import com.example.microservices.catalog.web.endpoint.ProcessingInfoEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(CatalogWebAutoConfiguration.class)
public class ExampleCatalogWebAutoConfiguration {

    @Configuration
    @ComponentScan(basePackageClasses = {ProcessingInfoEndpoint.class})
    static class ExampleCatalogWebControllers {
    }
}
