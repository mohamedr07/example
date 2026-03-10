package com.example.microservices.catalog.web.endpoint;

import com.broadleafcommerce.data.tracking.core.context.ContextInfo;
import com.broadleafcommerce.data.tracking.core.context.ContextOperation;
import com.broadleafcommerce.data.tracking.core.policy.Policy;
import com.broadleafcommerce.data.tracking.core.type.OperationType;
import com.example.microservices.catalog.domain.ProcessingInfo;
import com.example.microservices.catalog.service.ProcessingInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/processing")
@RequiredArgsConstructor
public class ProcessingInfoEndpoint {
    private final ProcessingInfoService processingInfoService;

    @Policy(permissionRoots = "CATALOG", operationTypes = OperationType.READ)
    @GetMapping
    public List<ProcessingInfo> getAll(@ContextOperation(OperationType.READ) ContextInfo contextInfo) throws BadRequestException {

        return processingInfoService.getAllProcessingInfos(contextInfo);

    }
}
