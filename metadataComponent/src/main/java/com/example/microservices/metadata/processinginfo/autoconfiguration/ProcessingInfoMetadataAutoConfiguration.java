package com.example.microservices.metadata.processinginfo.autoconfiguration;

import com.broadleafcommerce.metadata.dsl.core.Endpoint;
import com.broadleafcommerce.metadata.dsl.core.extension.views.browse.EntityBrowseView;
import com.broadleafcommerce.metadata.dsl.core.extension.views.browse.EntityGridView;
import com.broadleafcommerce.metadata.dsl.core.extension.views.details.CreateEntityView;
import com.broadleafcommerce.metadata.dsl.core.extension.views.details.EntityFormView;
import com.broadleafcommerce.metadata.dsl.core.extension.views.details.UpdateEntityView;
import com.broadleafcommerce.metadata.dsl.core.utils.Columns;
import com.broadleafcommerce.metadata.dsl.core.utils.Fields;
import com.broadleafcommerce.metadata.dsl.core.utils.Views;
import com.broadleafcommerce.metadata.dsl.registry.ComponentSource;
import com.broadleafcommerce.metadata.route.ComponentRouteLocator;
import com.broadleafcommerce.metadata.route.builder.RoutesBuilder;
import com.example.microservices.metadata.processinginfo.ProcessingInfoIds;
import com.example.microservices.metadata.processinginfo.ProcessingInfoPaths;
import com.example.microservices.metadata.processinginfo.ProcessingInfoProps;
import com.example.microservices.metadata.processinginfo.ProcessingInfoScopes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessingInfoMetadataAutoConfiguration {
    @Bean
    public ComponentRouteLocator processInfoMetadataRoutes(RoutesBuilder routesBuilder) {
        return routesBuilder.routes()
                .route("/processing-info", r -> r.componentId(ProcessingInfoIds.BROWSE)
                        .scope(ProcessingInfoScopes.PRODUCT))
                .route("/processing-info/create", r -> r.componentId(ProcessingInfoIds.CREATE)
                        .scope(ProcessingInfoScopes.PRODUCT))
                .route("/processing-info/:id", r -> r.componentId(ProcessingInfoIds.UPDATE)
                        .scope(ProcessingInfoScopes.PRODUCT))
                .build();
    }

    @Bean
    public ComponentSource processInfoMetadataComponents() {
        return registry -> registry
                .add(ProcessingInfoIds.BROWSE, getProcessInfoBrowse())
                .add(ProcessingInfoIds.CREATE, getProcessInfoCreate())
                .add(ProcessingInfoIds.UPDATE, getProcessInfoUpdate());
    }

    private EntityBrowseView<?> getProcessInfoBrowse() {
        return Views.entityBrowseView()
                .label("Processing Infos")
                .defaultGrid(this::getProcessInfo);
    }

    private EntityGridView<?> getProcessInfo(EntityGridView<?> grid) {
        return grid
                .label("process-info.browse")
                .readEndpoint(ep -> ep.narrowedPaging()
                        .uri(ProcessingInfoPaths.PROCESSING_INFO)
                        .method(Endpoint.Method.GET)
                        .scope(ProcessingInfoScopes.PRODUCT))
                .sortable()
                .filterByQueryBuilder()
                .createAction(a -> a.label("process-info.actions.create")
                        .linkById(ProcessingInfoIds.CREATE)
                        .scope(ProcessingInfoScopes.PRODUCT))
                .addColumn(ProcessingInfoProps.ID,
                        Columns.linkById(ProcessingInfoIds.UPDATE)
                                .label("process-info.columns.id")
                                .sortable()
                                .order(1000)
                                .filterAndSortAlias("contextId"))
                .addColumn(ProcessingInfoProps.NAME,
                        Columns.string()
                                .label("process-info.columns.name")
                                .order(1000))
                .addColumn(ProcessingInfoProps.URL,
                        Columns.string()
                                .label("process-info.columns.url")
                                .order(2000));
    }

    private CreateEntityView<?> getProcessInfoCreate() {
        return Views.entityViewCreate()
                .label("process-info.create")
                .backLinkById(ProcessingInfoIds.BROWSE)
                .submitEndpoint(ep -> ep
                        .uri(ProcessingInfoPaths.PROCESSING_INFO)
                        .method(Endpoint.Method.POST)
                        .scope(ProcessingInfoScopes.PRODUCT))
                .submitLabel("process-info.create.actions.submit")
                .addGeneralForm(getCreateGeneralForm());

    }


    private EntityFormView<?> getCreateGeneralForm() {
        return Views.entityForm()
                .addField(ProcessingInfoProps.NAME, Fields.string()
                        .label("process-info.fields.name")
                        .required()
                        .order(1000))
                .addField(ProcessingInfoProps.URL, Fields.string()
                        .label("process-info.fields.url")
                        .required()
                        .order(2000));
    }

    private UpdateEntityView<?> getProcessInfoUpdate() {
        return Views.entityViewUpdate()
                .label("process-info.update")
                .backLinkById(ProcessingInfoIds.BROWSE)
                .readUrl(ProcessingInfoPaths.PROCESSING_INFO_SINGLE, ProcessingInfoScopes.PRODUCT)
                .submitUrl(ProcessingInfoPaths.PROCESSING_INFO_SINGLE, ProcessingInfoScopes.PRODUCT)
                .submitLabel("process-info.update.actions.submit")
                .deleteUrl(ProcessingInfoPaths.PROCESSING_INFO_SINGLE, ProcessingInfoScopes.PRODUCT)
                .deleteLabel("process-info.update.actions.delete")
                .addGeneralForm(getUpdateGeneralForm());

    }


    private EntityFormView<?> getUpdateGeneralForm() {
        return Views.entityForm()
                .addField(ProcessingInfoProps.ID, Fields.string()
                        .label("process-info.fields.id")
                        .readOnly()
                        .order(1000))
                .addField(ProcessingInfoProps.NAME, Fields.string()
                        .label("process-info.fields.name")
                        .required()
                        .order(2000))
                .addField(ProcessingInfoProps.URL, Fields.string()
                        .label("process-info.fields.url")
                        .required()
                        .order(3000));

    }
}
