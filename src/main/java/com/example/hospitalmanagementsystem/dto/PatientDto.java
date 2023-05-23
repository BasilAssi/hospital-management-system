/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/21/2023
 * Time: 2:29 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.dto;

import lombok.Data;

@Data
public class PatientDto {


    private Long patientId;

    private String name;
    private String phone;
    private String email;

}
