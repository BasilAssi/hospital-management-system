/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/14/2023
 * Time: 2:28 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;
    private String phone;
    private String email;

//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<MedicalRecord> medicalHistory;
//
//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Appointment> appointments;
}
