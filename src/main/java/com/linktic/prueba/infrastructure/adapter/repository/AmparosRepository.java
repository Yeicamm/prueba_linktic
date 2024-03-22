package com.linktic.prueba.infrastructure.adapter.repository;

import com.linktic.prueba.infrastructure.adapter.entity.Amparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmparosRepository extends JpaRepository<Amparo, Long> {
}
