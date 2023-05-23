/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/22/2023
 * Time: 3:00 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.dto.DoctorDto;
import com.example.hospitalmanagementsystem.dto.MedicalRecordDto;
import com.example.hospitalmanagementsystem.service.DoctorService;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;
import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("/api/medicalRecord")
public class MedicalRecordController {


    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordDto>> getAllDoctors(){
        return ResponseEntity.ok(medicalRecordService.getAllMedicalRecords());
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDto> createDoctor (@Valid @RequestBody MedicalRecordDto medicalRecordDto) {
        return new ResponseEntity<>(medicalRecordService.addMedicalRecord(medicalRecordDto), HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDto> getDoctorById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(medicalRecordService.getMedicalRecordById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecordDto> updateCategory(@Valid @RequestBody MedicalRecordDto medicalRecordDto
            , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(medicalRecordService.updateMedicalRecord(medicalRecordDto, id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") long id) {
        medicalRecordService.deleteMedicalRecordById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

}

