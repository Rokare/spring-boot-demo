package com.farukgenc.boilerplate.springboot.controller;

import com.farukgenc.boilerplate.springboot.security.dto.LoginRequest;
import com.farukgenc.boilerplate.springboot.security.dto.LoginResponse;
import com.farukgenc.boilerplate.springboot.security.jwt.JwtTokenService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user-management")
public class UserManagementController {

	// private final JwtTokenService jwtTokenService;

	@PostMapping
	@Operation(tags = "User management Service")
	public ResponseEntity<String> UserOK() {


		return ResponseEntity.ok("OKOk");
	}

}
