/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/21/2023
 * Time: 2:31 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.dto;

import lombok.Data;

@Data
public class MedicalRecordDto {


    private Long recordId;
    private String diagnosis;
    private String treatment;


}
