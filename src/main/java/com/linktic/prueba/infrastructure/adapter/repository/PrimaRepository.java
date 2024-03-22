package com.linktic.prueba.infrastructure.adapter.repository;

import com.linktic.prueba.infrastructure.adapter.entity.Prima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimaRepository extends JpaRepository<Prima, Long> {
    @Query("SELECT p FROM Prima p WHERE :edad BETWEEN p.edadMinima AND p.edadMaxima")
    List<Prima> findPrimasByEdad(@Param("edad") int edad);
}
