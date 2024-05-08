package com.github.leovd100.capture.system.infraestructureLayer.repositories;

import com.github.leovd100.capture.system.domainLayer.entities.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeadRepository extends JpaRepository<Lead, UUID> {
}
