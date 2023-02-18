package com.example.PatientClinicalkey.Controller;

import com.example.PatientClinicalkey.Dto.ClinicalDataRequest;
import com.example.PatientClinicalkey.entities.ClinicalData;
import com.example.PatientClinicalkey.entities.Patient;
import com.example.PatientClinicalkey.repository.ClinicalDataRepository;
import com.example.PatientClinicalkey.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {

    private PatientRepository patientRepository;

    private ClinicalDataRepository clinicalDataRepository;

    public ClinicalDataController(PatientRepository patientRepository, ClinicalDataRepository clinicalDataRepository){
        this.patientRepository = patientRepository;
        this.clinicalDataRepository = clinicalDataRepository;
    }

    @RequestMapping(value = "/clinicals", method = RequestMethod.POST)
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request){
        Patient patient = patientRepository.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setPatient(patient);
        return clinicalDataRepository.save(clinicalData);
    }
}
