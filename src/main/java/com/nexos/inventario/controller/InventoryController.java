package com.nexos.inventario.controller;

import com.nexos.inventario.dto.InventoryRequestDto;
import com.nexos.inventario.dto.InventoryResponseDto;
import com.nexos.inventario.exception.CustomHttpException;
import com.nexos.inventario.service.IInventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final IInventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryResponseDto> createInventory(@RequestBody @Valid InventoryRequestDto inventoryRequestDto) throws CustomHttpException {
        return new ResponseEntity<>(inventoryService.createInventory(inventoryRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> updateInventory(@PathVariable Long id, @RequestBody @Valid InventoryRequestDto inventoryRequestDto) throws CustomHttpException {
        return ResponseEntity.ok(inventoryService.updateInventory(id, inventoryRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponseDto> getInventoryById(@PathVariable Long id) throws CustomHttpException {
        return ResponseEntity.ok(inventoryService.getInventoryById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id, @RequestParam Long userId) throws CustomHttpException {
        inventoryService.deleteInventory(id, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/active")
    public ResponseEntity<List<InventoryResponseDto>> getAllActiveInventory() {
        return ResponseEntity.ok(inventoryService.getAllActiveInventory());
    }

    @GetMapping("/search")
    public ResponseEntity<List<InventoryResponseDto>> searchInventory(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) LocalDate entryDate) {
        return ResponseEntity.ok(inventoryService.searchInventory(productName, userId, entryDate));
    }
}
