package io.github.rvdxk.entity;

import io.github.rvdxk.constant.CarMake;
import io.github.rvdxk.constant.CarModel;
import io.github.rvdxk.constant.CarType;
import io.github.rvdxk.constant.FuelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_cars")
public class UserCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarMake carMake;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarModel carModel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(nullable = false)
    @DecimalMin(value = "0.050")
    @DecimalMax(value = "12.0")
    private double capacity;

    @Column(nullable = false)
    @Min(1900)
    @Max(2024)
    private int prodYear;

    @OneToOne(mappedBy = "userCar")
    private User user;

}
