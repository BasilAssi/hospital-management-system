package com.example.hospitalmanagementsystem.service;


import com.example.hospitalmanagementsystem.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto addPatient(PatientDto patientDto);

    List<PatientDto> getAllPatients();

    PatientDto getPatientById(long id);

    PatientDto updatePatient(PatientDto patientDto, long id);

    void deletePatientById(long id);
}
