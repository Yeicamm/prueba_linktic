package com.linktic.prueba.infrastructure.adapter.repository;

import com.linktic.prueba.infrastructure.adapter.entity.Asegurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AseguradoRepository extends JpaRepository<Asegurado, Long> {
}
