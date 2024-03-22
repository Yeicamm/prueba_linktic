package com.linktic.prueba.application.usecase;

import com.linktic.prueba.domain.dto.AseguradoDto;
import com.linktic.prueba.domain.dto.LiquidacionDto;

public interface IAseguradoService {
    LiquidacionDto calcularLiquidacion(AseguradoDto aseguradoDTO);
}
