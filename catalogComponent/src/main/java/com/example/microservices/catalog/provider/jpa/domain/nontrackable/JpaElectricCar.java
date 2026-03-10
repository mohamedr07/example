package com.example.microservices.catalog.provider.jpa.domain.nontrackable;

import com.broadleafcommerce.catalog.provider.jpa.domain.product.JpaProduct;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "ELECTRIC_CAR")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JpaElectricCar extends JpaProduct {

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MAKE")
    private String make;
}
