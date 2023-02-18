package com.example.PatientClinicalkey.repository;

import com.example.PatientClinicalkey.entities.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {
}
