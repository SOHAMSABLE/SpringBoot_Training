package com.dec.arc.project.service;

import com.dec.arc.project.dto.UserPatchDTO;
import com.dec.arc.project.dto.UserRequestDTO;
import com.dec.arc.project.dto.UserResponseDTO;
import com.dec.arc.project.repository.UserRepository;
import com.dec.arc.project.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = mapper.map(dto, User.class);
        User saved = repo.save(user);
        return mapper.map(saved, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return repo.findAll()
                .stream()
                .map(user -> mapper.map(user, UserResponseDTO.class))
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        mapper.map(dto, user); // PATCH-like behavior

        return mapper.map(repo.save(user), UserResponseDTO.class);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
    @Override
    public UserResponseDTO patchUser(Long id, UserPatchDTO dto) {

        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (dto.getName() != null) {
            user.setName(dto.getName());
        }

        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        User saved = repo.save(user);
        return mapper.map(saved, UserResponseDTO.class);
    }

}
