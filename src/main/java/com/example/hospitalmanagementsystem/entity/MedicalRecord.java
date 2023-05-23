/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/14/2023
 * Time: 3:11 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;


//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    private Patient patient;
//
//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;

    private String diagnosis;
    private String treatment;
}
