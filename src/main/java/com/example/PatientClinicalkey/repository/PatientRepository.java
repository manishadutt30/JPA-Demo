package com.example.PatientClinicalkey.repository;

import com.example.PatientClinicalkey.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
