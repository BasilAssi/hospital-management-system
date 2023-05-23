package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.dto.DoctorDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DoctorService {

    DoctorDto addDoctor(DoctorDto doctorDto);

    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(long id);

    DoctorDto updateDoctor(DoctorDto doctorDto, long id);

    void deleteDoctorById(long id);

}
