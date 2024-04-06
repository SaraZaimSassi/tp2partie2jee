package com.example.patient_app.repositories;

import com.example.patient_app.entities.Patient;
import com.example.patient_app.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
