package com.nexos.inventario.controller;

import com.nexos.inventario.dto.ChargeRequestDto;
import com.nexos.inventario.dto.ChargeResponseDto;
import com.nexos.inventario.service.IChargeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/charges")
@RequiredArgsConstructor
public class ChargeController {
    private final IChargeService chargeService;

    @GetMapping
    public ResponseEntity<List<ChargeResponseDto>> findAllCharges() {
        return ResponseEntity.ok(chargeService.findAll());
    }

    @PostMapping
    public ResponseEntity<ChargeResponseDto> createCharge(@Valid @RequestBody ChargeRequestDto chargeRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chargeService.createCharge(chargeRequestDto));
    }
}
