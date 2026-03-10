package com.example.microservices.catalog.repository;

import com.broadleafcommerce.data.tracking.core.BaseTrackableRepository;
import com.broadleafcommerce.data.tracking.core.filtering.Narrow;
import com.broadleafcommerce.data.tracking.jpa.filtering.narrow.JpaNarrowExecutor;
import com.example.microservices.catalog.provider.jpa.domain.trackable.JpaProcessingInfo;
import org.springframework.stereotype.Repository;

@Repository
@Narrow(JpaNarrowExecutor.class)
public interface ProcessingInfoRepository extends BaseTrackableRepository<JpaProcessingInfo> {
}
