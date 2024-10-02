package com.nexos.inventario.service;

import com.nexos.inventario.dto.UserRequestDto;
import com.nexos.inventario.dto.UserResponseDto;
import com.nexos.inventario.exception.CustomHttpException;

import java.util.List;

public interface IUserService {

    UserResponseDto createUser(UserRequestDto userRequestDto) throws CustomHttpException;

    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) throws CustomHttpException;

    UserResponseDto getUserById(Long id) throws CustomHttpException;

    void deleteUser(Long id) throws CustomHttpException;

    List<UserResponseDto> getAllUsers();
}
