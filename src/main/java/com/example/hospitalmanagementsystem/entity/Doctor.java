/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/14/2023
 * Time: 2:23 PM
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


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Doctor  implements Serializable {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String name;
    private String specialization;
    private String workingHours;

//    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Appointment> appointments;
}
