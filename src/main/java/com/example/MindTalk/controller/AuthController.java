package com.example.MindTalk.controller;

import com.example.MindTalk.dto.ClientRegisterDTO;
import com.example.MindTalk.service.ClientRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private ClientRegisterService clientRegisterService;

    @PostMapping("/register-client")
    public ResponseEntity<?> registerClient(@Valid @RequestBody ClientRegisterDTO clientRegisterDTO) {
        clientRegisterService.clientRegister(clientRegisterDTO);
        return ResponseEntity.ok("Client Registered successfully");
    }

}
