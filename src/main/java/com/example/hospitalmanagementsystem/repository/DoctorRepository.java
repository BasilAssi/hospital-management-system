package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository  extends JpaRepository <Doctor , Long> {
}
