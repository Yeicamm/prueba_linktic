package com.linktic.prueba.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "asegurados")
public class Asegurado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroIdentificacion;

    private Integer tipoIdentificacion;
    private String apellidos;
    private String nombres;
    private Integer sexo;
    private LocalDate fechaNacimiento;
}

