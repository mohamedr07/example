package com.example.microservices.catalog.service.autoconfig;

import com.broadleafcommerce.catalog.service.autoconfigure.CatalogServiceAutoConfiguration;
import com.example.microservices.catalog.repository.ProcessingInfoRepository;
import com.example.microservices.catalog.service.ProcessingInfoService;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(CatalogServiceAutoConfiguration.class)
public class ExampleCatalogServiceAutoConfiguration {

    @Bean
    public ProcessingInfoService processingInfoService(ProcessingInfoRepository processingInfoRepository) {
        return new ProcessingInfoService(processingInfoRepository);
    }
}
