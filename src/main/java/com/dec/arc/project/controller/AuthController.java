package com.dec.arc.project.controller;

import com.dec.arc.project.dto.JwtResponse;
import com.dec.arc.project.dto.UserRequestDTO;
import com.dec.arc.project.dto.UserResponseDTO;
import com.dec.arc.project.security.JwtUtil;
import com.dec.arc.project.security.LoginRequest;
import com.dec.arc.project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

//@RestController
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//    private  final UserService userService;
//
//    public AuthController(AuthenticationManager authenticationManager,
//                          JwtUtil jwtUtil, UserService userService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//        this.userService = userService;
//    }
//    @PostMapping("/register")
//    public ResponseEntity<UserResponseDTO> register(
//            @RequestBody UserRequestDTO dto
//    ) {
//        return ResponseEntity.ok(userService.createUser(dto));
//    }
//
//    @PostMapping("/auth/login")
//    public ResponseEntity<JwtResponse> login(
//            @RequestBody LoginRequest request
//    ) {
//        Authentication authentication =
//                authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                request.getUsername(),
//                                request.getPassword()
//                        )
//                );
//
//        String token = jwtUtil.generateToken(
//                authentication.getName(),
//                authentication.getAuthorities()   // ⭐ ROLES HERE
//        );
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
//
//}
//
@RestController
@RequestMapping("/auth")
public class AuthController {
        private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private  final UserService userService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(
            @RequestBody UserRequestDTO dto
    ) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @RequestBody LoginRequest request
    ) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        String token = jwtUtil.generateToken(
                authentication.getName(),
                authentication.getAuthorities()
        );

        return ResponseEntity.ok(new JwtResponse(token));
    }
}

