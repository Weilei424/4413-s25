package com.yorku4413s25.leafwheels.domain;

import com.yorku4413s25.leafwheels.constants.BodyType;
import com.yorku4413s25.leafwheels.constants.Condition;
import com.yorku4413s25.leafwheels.constants.Make;
import com.yorku4413s25.leafwheels.constants.VehicleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column(nullable = false, name = "`year`")
    private int year;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Make make;

    @Column(length = 50, nullable = false)
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private BodyType bodyType;

    @Column(length = 30)
    private String exteriorColor;

    @Column(nullable = false)
    private int doors;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false)
    private int mileage;

    @Column(nullable = false)
    private int batteryRange;

    @Column(length = 50)
    private String trim;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean onDeal = false;

    @Column(length = 17, unique = true)
    private String vin;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Condition condition;

    @Column(length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private VehicleStatus status;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
