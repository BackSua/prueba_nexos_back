package com.nexos.inventario.service;

import com.nexos.inventario.dto.ChargeRequestDto;
import com.nexos.inventario.dto.ChargeResponseDto;
import com.nexos.inventario.entity.ChargeEntity;
import com.nexos.inventario.exception.CustomHttpException;

import java.util.List;

public interface IChargeService {
    ChargeEntity findById(Long id) throws CustomHttpException;

    // Método para listar todos los cargos
    List<ChargeResponseDto> findAll();

    // Método para crear un nuevo cargo
    ChargeResponseDto createCharge(ChargeRequestDto chargeRequestDto);
}
