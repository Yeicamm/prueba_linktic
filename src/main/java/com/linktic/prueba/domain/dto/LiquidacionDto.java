package com.linktic.prueba.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class LiquidacionDto {
    private Long tipoIdentificacion;
    private String numeroIdentificacion;
    private BigDecimal valorAsegurado;
    private List<AmparoDto> liquidacion;
    private BigDecimal valorTotal;
}
