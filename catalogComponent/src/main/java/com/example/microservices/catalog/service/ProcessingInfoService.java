package com.example.microservices.catalog.service;

import com.broadleafcommerce.data.tracking.core.context.ContextInfo;
import com.example.microservices.catalog.domain.ProcessingInfo;
import com.example.microservices.catalog.provider.jpa.domain.trackable.JpaProcessingInfo;
import com.example.microservices.catalog.repository.ProcessingInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class ProcessingInfoService {
    private final ProcessingInfoRepository processingInfoRepository;

    public List<ProcessingInfo> getAllProcessingInfos(ContextInfo context) {
        List<JpaProcessingInfo> jpaProcessingInfos = processingInfoRepository.findAll(context);

        return jpaProcessingInfos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ProcessingInfo convertToDto(JpaProcessingInfo jpaProcessingInfo) {
        ProcessingInfo dto = new ProcessingInfo();
        dto.setContextId(jpaProcessingInfo.getContextId());
        dto.setName(jpaProcessingInfo.getName());
        dto.setUrl(jpaProcessingInfo.getUrl());
        return dto;
    }
}
