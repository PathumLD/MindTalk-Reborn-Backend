package com.example.MindTalk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long clientId;

    private String dob;
    private String gender;
    private String phone;
    private String address;
    private String city;
    private String district;
    private String zip;
    private String emName1;
    private String emPhone1;
    private String emName2;
    private String emPhone2;
    private String emName3;
    private String emPhone3;
    @Column(name = "profile_photo_path")
    private String profilePhotoPath;
}
