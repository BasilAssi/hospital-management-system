/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/21/2023
 * Time: 4:55 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.controller;


import com.example.hospitalmanagementsystem.dto.PatientDto;


import com.example.hospitalmanagementsystem.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private final PatientService patientService;  // used interface for loose coupling

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }


    @PostMapping()
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.addPatient(patientDto), HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updateCategory(@Valid @RequestBody PatientDto patientDto
            , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(patientService.updatePatient(patientDto, id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") long id) {
        patientService.deletePatientById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }


}
