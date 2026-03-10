package com.example.microservices.catalog.provider.jpa.domain.trackable;

import com.broadleafcommerce.data.tracking.core.ApplicationTrackable;
import com.broadleafcommerce.data.tracking.jpa.filtering.TrackingListener;
import com.broadleafcommerce.data.tracking.jpa.filtering.domain.ApplicationJpaTracking;
import com.broadleafcommerce.data.tracking.jpa.hibernate.UlidUserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.io.Serializable;

@Entity
@Table(name = "PROCESSING_INFO")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode
@ToString
@EntityListeners(TrackingListener.class)
public class JpaProcessingInfo implements Serializable, ApplicationTrackable<ApplicationJpaTracking> {
    @Id
    @GeneratedValue(generator = "blcid")
    @GenericGenerator(name = "blcid", strategy = "blcid")
    @Type(UlidUserType.class)
    @Column(name = "ID", nullable = false, length = 36)
    private String contextId;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "URL", nullable = false)
    private String url;

    @Embedded
    private ApplicationJpaTracking tracking;
}
