package com.example.PatientClinicalkey.Controller;

import com.example.PatientClinicalkey.entities.ClinicalData;
import com.example.PatientClinicalkey.entities.Patient;
import com.example.PatientClinicalkey.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

    private PatientRepository patientRepository;
    Map<String, String> filterdata = new HashMap<>();

    @Autowired
    public PatientController(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "patients", method = RequestMethod.GET)
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") int id){
        return patientRepository.findById(id).get();
    }

    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public Patient save(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @RequestMapping(value = "/patients/analyze/{id}", method = RequestMethod.GET)
    public Patient analyze(@PathVariable("id") int id){
        Patient patient = patientRepository.findById(id).get();
        List<ClinicalData> clinicalDataList = patient.getClinicalDataList();
        List<ClinicalData> clinicalArrayList = new ArrayList<>(clinicalDataList);

        for (ClinicalData entryList:clinicalArrayList) {

            if (filterdata.containsKey(entryList.getComponentValue())) {
                clinicalDataList.remove(entryList);
                continue;
            }else{
                filterdata.put(entryList.getComponentName(), null);
            }
            if(entryList.getComponentName().equals("hw")){
                String[] heightAndWeight = entryList.getComponentValue().split("/");
                if(heightAndWeight.length > 1){
                    float height = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
                    float bmi = Float.parseFloat(heightAndWeight[1])/(height*height);
                    ClinicalData clinicalData = new ClinicalData();
                    clinicalData.setComponentName("bmi");
                    clinicalData.setComponentValue(Float.toString(bmi));
                    clinicalDataList.add(clinicalData);
                }
            }
        }
        filterdata.clear();
        return patient;
    }
}
