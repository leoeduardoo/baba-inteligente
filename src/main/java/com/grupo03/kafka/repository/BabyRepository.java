package com.grupo03.kafka.repository;

import com.grupo03.kafka.model.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Long> {
    Optional<Baby> findFirstByParentId(Long parentId);
}