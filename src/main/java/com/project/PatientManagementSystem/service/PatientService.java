package com.project.PatientManagementSystem.service;

import com.project.PatientManagementSystem.dto.PatientRequestDTO;
import com.project.PatientManagementSystem.dto.PatientResponseDTO;
import com.project.PatientManagementSystem.exception.EmailAlreadyExistsException;
import com.project.PatientManagementSystem.exception.PatientNotFoundException;
import com.project.PatientManagementSystem.mapper.PatientMapper;
import com.project.PatientManagementSystem.model.Patient;
import com.project.PatientManagementSystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO){
        Patient newPatient = PatientMapper.toModel(patientRequestDTO);
        patientRepository.save(newPatient);
        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("Patient Not Found "+id));
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists with email "+patientRequestDTO.getEmail());
        }
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDob(LocalDate.parse(patientRequestDTO.getDob()));
        patient.setAddress(patientRequestDTO.getAddress());
        patientRepository.save(patient);
        return PatientMapper.toDTO(patient);
    }

    public String deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("Patient Not Found "+id));
        patientRepository.delete(patient);
        return "Patient Deleted Successfully";
    }
}
