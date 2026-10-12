package com.axlero.orderflow.controller;

import com.axlero.orderflow.helper.ResetPasswordRequest;
import com.axlero.orderflow.repository.CustomerRepository;
import com.axlero.orderflow.service.AuthService;
import com.axlero.orderflow.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ModelMapper modelMapper;
    private final CustomerRepository userRepository;
    private final AuthService authService;
    private final CustomerService customerService;



    @GetMapping("/is-authenticated")
    public ResponseEntity<Boolean> isAuthenticated(@RequestParam String email) {
        return ResponseEntity.ok(email != null && userRepository.findByEmail(email).isPresent());
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        authService.resetPassword(request.getEmail(), request.getOtp(), request.getNewPassword());
        return ResponseEntity.ok("Password changed successfully");
    }

    @PostMapping("/resend-registration-otp")
    public ResponseEntity<String> resendRegistrationOtp(
            @RequestParam String email) {

        authService.sendOtp(email);

        return ResponseEntity.ok("Registration OTP sent successfully");
    }
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyEmail(@RequestBody Map<String, Object> request, @RequestParam String email) {
        if (request.get("otp") == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing OTP in request");
        }
        try {
            authService.verifyOtp(email, request.get("otp").toString());
            return ResponseEntity.ok("OTP verified successfully");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

