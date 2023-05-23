/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/21/2023
 * Time: 4:12 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.dto.AppointmentDto;


import com.example.hospitalmanagementsystem.service.AppointmentService;
import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;  // used interface for loose coupling

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;

    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments(){

        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PostMapping(path ="/add")
    public ResponseEntity<AppointmentDto> createAppointment (@Valid @RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentService.addAppointment(appointmentDto), HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getDoctorById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateCategory(@Valid @RequestBody AppointmentDto appointmentDto
            , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(appointmentService.updateAppointment(appointmentDto, id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") long id) {
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }


}
