/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/14/2023
 * Time: 9:33 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.dto.DoctorDto;
import com.example.hospitalmanagementsystem.exception.BadRequestException;
import com.example.hospitalmanagementsystem.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {


@Autowired
    private final DoctorService doctorService;  // used interface for loose coupling

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
@GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor (@Valid  @RequestBody DoctorDto doctorDto) {
       return new ResponseEntity<>(doctorService.addDoctor(doctorDto), HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateCategory(@Valid @RequestBody DoctorDto doctorDto
            , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(doctorService.updateDoctor(doctorDto, id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") long id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

}
