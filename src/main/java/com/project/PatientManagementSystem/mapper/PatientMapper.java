package com.project.PatientManagementSystem.mapper;

import com.project.PatientManagementSystem.dto.PatientResponseDTO;
import com.project.PatientManagementSystem.model.Patient;

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

}
