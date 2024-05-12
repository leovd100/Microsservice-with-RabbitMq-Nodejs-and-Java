package com.github.leovd100.message.service.infraestructureLayer.repositories;

import com.github.leovd100.message.service.domainLayer.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeadRepository extends JpaRepository<Lead, UUID> {
}
