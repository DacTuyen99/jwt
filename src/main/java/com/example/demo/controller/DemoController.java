package com.example.demo.controller;

import com.example.demo.auth.AuthenticationRequest;
import com.example.demo.auth.AuthenticationResponse;
import com.example.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {
    private final AuthenticationService authenticationService;
    @GetMapping("/test")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("Authentication and authorization is succeeded");
    }
}
