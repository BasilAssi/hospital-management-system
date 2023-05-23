/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/21/2023
 * Time: 2:30 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentDto {
    private Long appointmentId;



    private Date date;
    private LocalTime time;
}
