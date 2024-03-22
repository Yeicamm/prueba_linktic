package com.linktic.prueba.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AmparoDto {
    private Long codigoAmparo;
    private String nombreAmparo;
    private BigDecimal valorPrima;

}
