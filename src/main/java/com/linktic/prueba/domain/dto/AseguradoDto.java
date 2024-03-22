package com.linktic.prueba.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class AseguradoDto {
    @NotNull
    private Long tipoIdentificacion;
    @NotBlank
    private String numeroIdentificacion;
    @NotNull
    private BigDecimal valorAsegurado;
    private LocalDate fechaNacimiento;
}
