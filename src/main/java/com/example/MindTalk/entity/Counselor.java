package com.example.MindTalk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "counselor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Counselor extends User{

    @Column(length = 100000)
    private String about;
    private Long licenseNo;
    private String licenseImage;
    private String jobRole;
    private String address;
    private String phone;
    private String degree;
    private String workplace;
    private String coreServices;
    private String scopeOfPractice;
    private String experience;
    private String ageGroup;
    private String language;
    private String joinDate;
    private Boolean status;
    @Column(name = "profile_photo_path")
    private String profilePhotoPath;
}
