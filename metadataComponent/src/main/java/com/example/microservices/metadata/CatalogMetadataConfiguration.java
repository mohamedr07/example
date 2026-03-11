package com.example.microservices.metadata;

import com.broadleafcommerce.catalog.metadata.autoconfigure.CatalogMetadataProperties;
import com.broadleafcommerce.catalog.metadata.support.DefaultProductType;
import com.broadleafcommerce.catalog.metadata.support.ProductGroups;
import com.broadleafcommerce.catalog.metadata.support.ProductIds;
import com.broadleafcommerce.metadata.dsl.core.extension.views.details.EntityView;
import com.broadleafcommerce.metadata.dsl.core.utils.Fields;
import com.broadleafcommerce.metadata.dsl.registry.ComponentSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.broadleafcommerce.catalog.metadata.support.DefaultProductType.values;

@Configuration
public class CatalogMetadataConfiguration {
//
//    @Bean
//    public ComponentSource tutorialProductAdminMetadata(@Nullable CatalogMetadataProperties properties) {
//        return registry -> {
//            // Discover the active product types
//            List<DefaultProductType> types = Arrays.stream(values())
//                    .filter(t -> ((Optional.ofNullable(properties))
//                            .map(item -> item.getActiveProductTypes().contains(t.name()))
//                            .orElse(false)))
//                    .toList();
//            for (DefaultProductType type : types) {
//                // For each product type, add the new field to the create and update forms
//                List<EntityView<?>> views = Arrays.asList(
//                        (EntityView<?>) registry.get(String.format(ProductIds.CREATE, type.name())),
//                        (EntityView<?>) registry.get(String.format(ProductIds.UPDATE, type.name()))
//                );
//
//                for (EntityView<?> view : views) {
//                    // Get the basic information group
//                    var basicGroup = view.getGeneralForm().getGroup(ProductGroups.BASIC_INFORMATION);
//
//                    // Add the "model" field
//                    basicGroup.addField(Fields.string()
//                            .name("model")
//                            .label("Model"));
//
//                    // Add the "color" field
//                    basicGroup.addField(Fields.string()
//                            .name("make")
//                            .label("Make"));
//                }
//            }
//        };
//    }

}
