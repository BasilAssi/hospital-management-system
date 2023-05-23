/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 5/14/2023
 * Time: 8:43 PM
 * Project Name: hospital-management-system
 */

package com.example.hospitalmanagementsystem.service.impl;

import com.example.hospitalmanagementsystem.dto.DoctorDto;
import com.example.hospitalmanagementsystem.entity.Doctor;
import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.repository.DoctorRepository;
import com.example.hospitalmanagementsystem.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {

        this.doctorRepository = doctorRepository;
    }


    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        // convert DTO to entity
        Doctor doctor = mapToEntity(doctorDto);
        Doctor newDoctor = doctorRepository.save(doctor);
        // convert entity to DTO
        DoctorDto doctorResponse = mapToDTO(newDoctor);
        return doctorResponse;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map( doctor -> mapToDTO(doctor)).collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorById(long id) {
        Doctor doctor =  doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("doctor" , "id",id));
        return mapToDTO(doctor);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, long id) {
        // get doctor by id from the database
        Doctor doctor =  doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("doctor" , "id" , id));
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setWorkingHours(doctorDto.getWorkingHours());

//        doctor.setAppointments(doctorDto.getAppointments());
        Doctor updatedDoctor = doctorRepository.save(doctor);
        return mapToDTO(updatedDoctor);
    }

    @Override
    public void deleteDoctorById(long id) {
        Doctor doctor= doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("doctor" ,"id" ,id));
        doctorRepository.delete(doctor);
    }


    // convert Entity into DTO
    private DoctorDto mapToDTO(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctorId(doctor.getDoctorId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setWorkingHours(doctor.getWorkingHours());
      //  doctorDto.setAppointments(doctor.getAppointments());
        return doctorDto;
    }

    // convert DTO to entity
    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setWorkingHours(doctorDto.getWorkingHours());
       // doctor.setAppointments(doctorDto.getAppointments());
        return doctor;
    }
}
