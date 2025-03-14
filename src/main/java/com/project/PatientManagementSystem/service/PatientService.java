package com.project.PatientManagementSystem.service;

import com.project.PatientManagementSystem.dto.PatientResponseDTO;
import com.project.PatientManagementSystem.mapper.PatientMapper;
import com.project.PatientManagementSystem.model.Patient;
import com.project.PatientManagementSystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }




}
