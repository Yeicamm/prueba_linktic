package com.linktic.prueba.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "primas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_amparo")
    private Long codigoAmparo;

    private Long edadMinima;
    private Long edadMaxima;
    private BigDecimal porcentajePrima;


}