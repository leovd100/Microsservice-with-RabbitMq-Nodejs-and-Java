package com.github.leovd100.infotoken.repository;

import com.github.leovd100.infotoken.model.entity.InformationEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface InfoRepository extends JpaRepository<InformationEntity, UUID> {
}
