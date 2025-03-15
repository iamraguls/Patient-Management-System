package com.project.PatientManagementSystem.controller;


import com.project.PatientManagementSystem.dto.PatientRequestDTO;
import com.project.PatientManagementSystem.dto.PatientResponseDTO;
import com.project.PatientManagementSystem.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientResponseDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public PatientResponseDTO addPatient(@RequestBody PatientRequestDTO patientRequestDTO){
        return patientService.addPatient(patientRequestDTO);
    }

    @PutMapping("/{id}")
    public PatientResponseDTO updatePatient(@PathVariable Long id,@RequestBody PatientRequestDTO patientRequestDTO){
        return patientService.updatePatient(id,patientRequestDTO);
    }

}
