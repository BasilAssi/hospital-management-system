package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord , Long> {
}
