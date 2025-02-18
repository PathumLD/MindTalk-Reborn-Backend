package com.example.MindTalk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor  // This should generate a default constructor, but let's add it explicitly
@AllArgsConstructor
@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true)
    private ERole name;

    // Explicitly add default constructor
    public Role() {
    }

    public Role(ERole eRole) {
        this.name = eRole;
    }
}