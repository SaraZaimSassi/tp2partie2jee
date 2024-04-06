package com.example.patient_app.repositories;

import com.example.patient_app.entities.Consultation;
import com.example.patient_app.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
