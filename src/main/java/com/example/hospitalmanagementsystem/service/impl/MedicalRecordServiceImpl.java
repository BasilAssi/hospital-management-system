/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/21/2023
 * Time: 5:14 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.dto.DoctorDto;
import com.example.hospitalmanagementsystem.dto.MedicalRecordDto;
import com.example.hospitalmanagementsystem.dto.PatientDto;
import com.example.hospitalmanagementsystem.entity.Doctor;
import com.example.hospitalmanagementsystem.entity.MedicalRecord;
import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.repository.MedicalRecordRepository;
import com.example.hospitalmanagementsystem.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {


    @Autowired
    MedicalRecordRepository medicalRecordRepository;
    @Override
    public MedicalRecordDto addMedicalRecord(MedicalRecordDto medicalRecordDto) {
        // convert DTO to entity
        MedicalRecord medicalRecord = mapToEntity(medicalRecordDto);
        MedicalRecord newMedicalRecord = medicalRecordRepository.save(medicalRecord);

        // convert entity to DTO
        MedicalRecordDto medicalRecordDtoResponse = mapToDTO(newMedicalRecord);
        return medicalRecordDtoResponse;
    }



    @Override
    public List<MedicalRecordDto> getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findAll();
        return medicalRecords.stream().map( medicalRecord -> mapToDTO(medicalRecord)).collect(Collectors.toList());
    }

    @Override
    public MedicalRecordDto getMedicalRecordById(long id) {
        MedicalRecord category = medicalRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord", "id", id));
        return mapToDTO(category);
    }

    @Override
    public MedicalRecordDto updateMedicalRecord(MedicalRecordDto medicalRecordDto, long id) {
        // get category by id from the database
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord", "id", id));

        medicalRecord.setDiagnosis(medicalRecordDto.getDiagnosis());
        medicalRecord.setTreatment(medicalRecordDto.getTreatment());


        MedicalRecord updatedMedicalRecord = medicalRecordRepository.save(medicalRecord);
        return mapToDTO(updatedMedicalRecord);
    }

    @Override
    public void deleteMedicalRecordById(long id) {
        // get category by id from the database
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord", "id", id));
        medicalRecordRepository.delete(medicalRecord);
    }


    private MedicalRecordDto mapToDTO(MedicalRecord medicalRecord) {

        MedicalRecordDto medicalRecordDto = new MedicalRecordDto();
        medicalRecordDto.setRecordId(medicalRecord.getRecordId());
        medicalRecordDto.setDiagnosis(medicalRecord.getDiagnosis());
        return medicalRecordDto;
    }

    private MedicalRecord mapToEntity(MedicalRecordDto medicalRecordDto) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setRecordId(medicalRecordDto.getRecordId());
        medicalRecord.setTreatment(medicalRecordDto.getTreatment());
        medicalRecord.setDiagnosis(medicalRecordDto.getDiagnosis());

        return medicalRecord;
    }
}
