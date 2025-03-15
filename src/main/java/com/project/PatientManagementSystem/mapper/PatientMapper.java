package com.project.PatientManagementSystem.mapper;

import com.project.PatientManagementSystem.dto.PatientRequestDTO;
import com.project.PatientManagementSystem.dto.PatientResponseDTO;
import com.project.PatientManagementSystem.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setDob(patient.getDob().toString());
        patientResponseDTO.setEmail(patient.getEmail());
        return patientResponseDTO;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setName(patientRequestDTO.getName());
        patient.setDob(LocalDate.parse(patientRequestDTO.getDob()));
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return patient;
    }

}
