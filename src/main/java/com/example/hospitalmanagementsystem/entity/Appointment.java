/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/14/2023
 * Time: 3:17 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.time.LocalTime;
import java.util.Date;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Appointment implements Serializable {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long appointmentId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "patient_id")
//    @JsonBackReference
//    private Patient patient;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "doctor_id")
//    @JsonBackReference
//    private Doctor doctor;

    private Date date;
    private LocalTime time;

}
