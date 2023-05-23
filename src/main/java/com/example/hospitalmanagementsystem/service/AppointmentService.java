package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.dto.AppointmentDto;


import java.util.List;

public interface AppointmentService {

    AppointmentDto addAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointmentById(long id);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto, long id);

    void deleteAppointmentById(long id);

}
