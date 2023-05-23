/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/21/2023
 * Time: 4:43 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.dto.PatientDto;
import com.example.hospitalmanagementsystem.entity.Patient;
import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.repository.PatientRepository;
import com.example.hospitalmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {



    @Autowired
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto addPatient(PatientDto patientDto) {

        // convert DTO to entity
        Patient patient = mapToEntity(patientDto);
        Patient newPatient = patientRepository.save(patient);

        // convert entity to DTO
        PatientDto patientResponse = mapToDTO(newPatient);
        return patientResponse;
    }



    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(patient -> mapToDTO(patient))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        return mapToDTO(patient);
    }



    @Override
    public PatientDto updatePatient(PatientDto patientDto, long id) {
        // get patient by id from the database
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));

        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone(patientDto.getPhone());


        Patient updatedPatient = patientRepository.save(patient);
        return mapToDTO(updatedPatient);
    }

    @Override
    public void deletePatientById(long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        patientRepository.delete(patient);
    }


    private PatientDto mapToDTO(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setPatientId(patient.getPatientId());
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setPhone(patient.getPhone());
        return patientDto;
    }

    private Patient mapToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setPatientId(patientDto.getPatientId());
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone(patientDto.getPhone());
        return patient;
    }

}
