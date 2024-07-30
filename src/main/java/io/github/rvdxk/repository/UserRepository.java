package io.github.rvdxk.repository;

import io.github.rvdxk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
