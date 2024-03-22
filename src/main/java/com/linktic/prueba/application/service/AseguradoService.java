package com.linktic.prueba.application.service;

import com.linktic.prueba.application.usecase.IAseguradoService;
import com.linktic.prueba.domain.dto.AmparoDto;
import com.linktic.prueba.domain.dto.AseguradoDto;
import com.linktic.prueba.domain.dto.LiquidacionDto;
import com.linktic.prueba.infrastructure.adapter.entity.Amparo;
import com.linktic.prueba.infrastructure.adapter.entity.Prima;
import com.linktic.prueba.infrastructure.adapter.repository.AmparosRepository;
import com.linktic.prueba.infrastructure.adapter.repository.PrimaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AseguradoService implements IAseguradoService {
    private final PrimaRepository primaRepository;
    private final AmparosRepository amparoRepository;

    @Override
    public LiquidacionDto calcularLiquidacion(AseguradoDto aseguradoDTO) throws IllegalArgumentException{
        if (aseguradoDTO.getValorAsegurado().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El valor asegurado debe ser mayor a cero");
        }
        LiquidacionDto liquidacionDTO = new LiquidacionDto();
        liquidacionDTO.setTipoIdentificacion(aseguradoDTO.getTipoIdentificacion());
        liquidacionDTO.setNumeroIdentificacion(aseguradoDTO.getNumeroIdentificacion());
        liquidacionDTO.setValorAsegurado(aseguradoDTO.getValorAsegurado());
        liquidacionDTO.setLiquidacion(new ArrayList<>());
        BigDecimal valorTotal = BigDecimal.ZERO;

        int edad = calcularEdad(aseguradoDTO.getFechaNacimiento());
        List<Prima> primasAplicables = primaRepository.findPrimasByEdad(edad);

        for (Prima prima : primasAplicables) {
            BigDecimal valorPrima = aseguradoDTO.getValorAsegurado().multiply(prima.getPorcentajePrima());
            valorTotal = valorTotal.add(valorPrima);

            Amparo amparo = amparoRepository.findById(prima.getCodigoAmparo())
                    .orElseThrow(() -> new RuntimeException("Amparo no encontrado"));
            liquidacionDTO.getLiquidacion().add(new AmparoDto(amparo.getCodigo(), amparo.getNombre(), valorPrima));
        }
        liquidacionDTO.setValorTotal(valorTotal);
        return liquidacionDTO;
    }
    private int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
