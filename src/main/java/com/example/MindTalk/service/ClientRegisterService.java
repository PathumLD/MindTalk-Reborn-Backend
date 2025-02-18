package com.example.MindTalk.service;

import com.example.MindTalk.dto.ClientRegisterDTO;
import com.example.MindTalk.entity.ERole;
import com.example.MindTalk.entity.Role;
import com.example.MindTalk.entity.User;
import com.example.MindTalk.repository.RoleRepository;
import com.example.MindTalk.repository.UserRepository;
import com.example.MindTalk.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class ClientRegisterService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired // This annotation is optional for constructor injection in modern Spring
    public ClientRegisterService(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Transactional
    public User clientRegister(ClientRegisterDTO clientRegisterDTO) {
        if (userRepository.existsByEmail(clientRegisterDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }

            // Create new user
            User user = new User();
            user.setFirstName(clientRegisterDTO.getFirstName());
            user.setLastName(clientRegisterDTO.getLastName());
            user.setEmail(clientRegisterDTO.getEmail());

            // Encode password
            user.setPassword(passwordEncoder.encodePassword(clientRegisterDTO.getPassword()));

            // Set default role as Client
            Role clientRole = roleRepository.findByName(ERole.Client)
                    .orElseThrow(() -> new RuntimeException("Error: Client Role not found."));

            user.setRoles(Collections.singleton(clientRole));

            // Save user
            return userRepository.save(user);
        }
    }


