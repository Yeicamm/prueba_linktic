package com.linktic.prueba.infrastructure.rest.controller;

import com.linktic.prueba.application.usecase.IAseguradoService;
import com.linktic.prueba.domain.dto.AseguradoDto;
import com.linktic.prueba.domain.dto.LiquidacionDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/asegurado")
@RequiredArgsConstructor
public class AseguradosController {
    private final IAseguradoService iAseguradoService;

    @PostMapping("/calcularLiquidacion")
    public ResponseEntity<?> calcularLiquidacion(@Valid @RequestBody AseguradoDto aseguradoDTO) {
        try {
            LiquidacionDto liquidacionDTO = iAseguradoService.calcularLiquidacion(aseguradoDTO);
            return new ResponseEntity<>(liquidacionDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
