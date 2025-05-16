package com.iskandarov.backend_services.controller;

import com.iskandarov.backend_services.dto.AuthRequest;
import com.iskandarov.backend_services.dto.AuthResponse;
import com.iskandarov.backend_services.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  private final AuthenticationManager authManager;
  private final JwtUtils jwtUtils;

  public AuthController(AuthenticationManager authManager, JwtUtils jwtUtils) {
    this.authManager = authManager;
    this.jwtUtils = jwtUtils;
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
    Authentication authentication =
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    String token = jwtUtils.generateToken(userDetails);

    return ResponseEntity.ok(new AuthResponse(token));
  }
}
