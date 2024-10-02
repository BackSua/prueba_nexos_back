package com.nexos.inventario.service;

import com.nexos.inventario.dto.InventoryRequestDto;
import com.nexos.inventario.dto.InventoryResponseDto;
import com.nexos.inventario.exception.CustomHttpException;

import java.time.LocalDate;
import java.util.List;

public interface IInventoryService {

    // Método para crear un nuevo producto en el inventario
    InventoryResponseDto createInventory(InventoryRequestDto inventoryRequestDto) throws CustomHttpException;

    // Método para actualizar un producto existente en el inventario
    InventoryResponseDto updateInventory(Long id, InventoryRequestDto inventoryRequestDto) throws CustomHttpException;

    // Método para obtener los detalles de un producto por su ID
    InventoryResponseDto getInventoryById(Long id) throws CustomHttpException;

    // Método para eliminar lógicamente un producto del inventario (cambiar su estado)
    void deleteInventory(Long id,Long userId) throws CustomHttpException;

    // Método para listar todos los productos activos en el inventario
    List<InventoryResponseDto> getAllActiveInventory();

    // Método para buscar productos por filtros (nombre, usuario o fecha)
    List<InventoryResponseDto> searchInventory(String productName, Long userId, LocalDate entryDate);
}