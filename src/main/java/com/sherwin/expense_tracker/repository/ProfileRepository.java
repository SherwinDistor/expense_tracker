package com.sherwin.expense_tracker.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sherwin.expense_tracker.domain.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {

  Optional<ProfileEntity> findByEmail(String email);

  Optional<ProfileEntity> findByActivationToken(String activationToken);

}
