package io.github.rvdxk.repository;

import io.github.rvdxk.entity.UserCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<UserCar, Long> {
}
