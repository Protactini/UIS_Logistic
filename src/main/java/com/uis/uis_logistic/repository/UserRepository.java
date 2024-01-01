package com.uis.uis_logistic.repository;

import com.uis.uis_logistic.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findUsersByUsername(String username);

    Boolean existsByUsername(String username);

}
