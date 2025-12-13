package com.dec.arc.project.service;

import com.dec.arc.project.dto.UserPatchDTO;
import com.dec.arc.project.dto.UserRequestDTO;
import com.dec.arc.project.dto.UserResponseDTO;
import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseDTO updateUser(Long id, UserRequestDTO dto);

    boolean deleteUser(Long id);

    UserResponseDTO patchUser(Long id, UserPatchDTO dto);

}
