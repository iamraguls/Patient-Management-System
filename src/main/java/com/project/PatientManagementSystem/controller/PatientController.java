package com.project.PatientManagementSystem.controller;


import com.project.PatientManagementSystem.dto.PatientRequestDTO;
import com.project.PatientManagementSystem.dto.PatientResponseDTO;
import com.project.PatientManagementSystem.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient", description = "Patient Management")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get All Patients")
    public List<PatientResponseDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    @Operation(summary = "Add Patient")
    public PatientResponseDTO addPatient(@RequestBody PatientRequestDTO patientRequestDTO){
        return patientService.addPatient(patientRequestDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Patient")
    public PatientResponseDTO updatePatient(@PathVariable Long id,@RequestBody PatientRequestDTO patientRequestDTO){
        return patientService.updatePatient(id,patientRequestDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete A Patient")
    public String deletePatient(@PathVariable Long id){
        return patientService.deletePatient(id);
    }

}
