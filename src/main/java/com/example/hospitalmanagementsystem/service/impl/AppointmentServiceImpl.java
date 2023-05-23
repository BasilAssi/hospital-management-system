/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/21/2023
 * Time: 2:37 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.dto.AppointmentDto;

import com.example.hospitalmanagementsystem.entity.Appointment;

import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.repository.AppointmentRepository;
import com.example.hospitalmanagementsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        // convert DTO to entity
        Appointment appointment = mapToEntity(appointmentDto);
        Appointment newAppointment = appointmentRepository.save(appointment);
        // convert entity to DTO
        AppointmentDto appointmentResponse = mapToDTO(newAppointment);
        return appointmentResponse;
    }




    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(appointment -> mapToDTO(appointment))
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto getAppointmentById(long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        return mapToDTO(appointment);}

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto, long id) {
        // get category by id from the database
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));

        appointment.setAppointmentId(appointmentDto.getAppointmentId());
        appointment.setDate(appointmentDto.getDate());
        appointment.setTime(appointmentDto.getTime());

        Appointment updatedCategory = appointmentRepository.save(appointment);
        return mapToDTO(updatedCategory);
    }

    @Override
    public void deleteAppointmentById(long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        appointmentRepository.delete(appointment);
    }

    private AppointmentDto mapToDTO(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setAppointmentId(appointment.getAppointmentId());
        appointmentDto.setDate(appointment.getDate());
        appointmentDto.setTime(appointment.getTime());
        return appointmentDto;
    }

    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(appointmentDto.getAppointmentId());
        appointment.setDate(appointmentDto.getDate());
        appointment.setTime(appointmentDto.getTime());
        return appointment;
    }


}
