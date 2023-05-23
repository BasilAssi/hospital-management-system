/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/14/2023
 * Time: 8:44 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.dto;

import com.example.hospitalmanagementsystem.entity.Appointment;
import com.example.hospitalmanagementsystem.entity.Patient;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class DoctorDto {


    private long doctorId;
    private String name;
    private String specialization;
    private String workingHours;
//    private List<Patient> patients;
  //  private List<Appointment> appointments;
}
