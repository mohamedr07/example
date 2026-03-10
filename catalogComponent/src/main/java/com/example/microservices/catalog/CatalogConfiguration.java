package com.example.microservices.catalog;

import com.broadleafcommerce.catalog.provider.RouteConstants;
import com.broadleafcommerce.common.extension.data.DataRoutes;
import com.broadleafcommerce.common.jpa.autoconfigure.CommonJpaAutoConfiguration;
import com.broadleafcommerce.common.jpa.data.entity.JpaEntityScan;
import com.broadleafcommerce.data.tracking.jpa.filtering.auto.EnableJpaTrackableFlow;
import com.broadleafcommerce.data.tracking.jpa.filtering.narrow.factory.JpaTrackableRepositoryFactoryBean;
import com.example.microservices.catalog.provider.jpa.domain.trackable.JpaProcessingInfo;
import com.example.microservices.catalog.repository.ProcessingInfoRepository;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static com.broadleafcommerce.catalog.provider.jpa.JpaRouteConstants.Persistence.CATALOG_ENTITY_MANAGER_FACTORY;
import static com.broadleafcommerce.catalog.provider.jpa.JpaRouteConstants.Persistence.CATALOG_TRANSACTION_MANAGER;

@Configuration
public class CatalogConfiguration {

    @Configuration
    @AutoConfigureBefore(CommonJpaAutoConfiguration.class)
    @JpaEntityScan(basePackages = {"com.example.microservices.catalog.provider.jpa.domain.nontrackable"},
            routePackage = RouteConstants.Persistence.CATALOG_ROUTE_PACKAGE)
    public static class NonTrackableEntities {

    }

    @Configuration
    @AutoConfigureBefore(CommonJpaAutoConfiguration.class)
    @EnableJpaTrackableFlow(
            entityClass = JpaProcessingInfo.class,
            routeKey = DataRoutes.CATALOG,
            permissionRoots = "CATALOG",
            rootPath = "/processing-info")
    public static class ProcessingInfoConfig {
    }

    @Configuration
    @AutoConfigureBefore(CommonJpaAutoConfiguration.class)
    @EnableJpaRepositories(
            basePackageClasses = {ProcessingInfoRepository.class},
            repositoryFactoryBeanClass = JpaTrackableRepositoryFactoryBean.class,
            entityManagerFactoryRef = CATALOG_ENTITY_MANAGER_FACTORY,
            transactionManagerRef = CATALOG_TRANSACTION_MANAGER
    )
    public static class ProcessingInfoRepositoryConfig {
    }
}
