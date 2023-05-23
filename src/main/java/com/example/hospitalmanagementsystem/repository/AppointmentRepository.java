package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
}
