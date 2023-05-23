package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.dto.MedicalRecordDto;
import com.example.hospitalmanagementsystem.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {

    MedicalRecordDto addMedicalRecord(MedicalRecordDto medicalRecordDto);

    List<MedicalRecordDto> getAllMedicalRecords();

    MedicalRecordDto getMedicalRecordById(long id);

    MedicalRecordDto updateMedicalRecord(MedicalRecordDto medicalRecordDto, long id);

    void deleteMedicalRecordById(long id);
}
