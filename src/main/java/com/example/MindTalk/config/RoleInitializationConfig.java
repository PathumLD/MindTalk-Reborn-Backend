package com.example.MindTalk.config;

import com.example.MindTalk.entity.ERole;
import com.example.MindTalk.entity.Role;
import com.example.MindTalk.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleInitializationConfig {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        createRoleIfNotExists(ERole.Admin);
        createRoleIfNotExists(ERole.Moderator);
        createRoleIfNotExists(ERole.Client);
        createRoleIfNotExists(ERole.Counsellor);
    }

    private void createRoleIfNotExists(ERole roleName) {
        if (!roleRepository.findByName(roleName).isPresent()) {
            // Use the constructor that takes ERole parameter
            Role role = new Role(roleName);
            roleRepository.save(role);
        }
    }
}