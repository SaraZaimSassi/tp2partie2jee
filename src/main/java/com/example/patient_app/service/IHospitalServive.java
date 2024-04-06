package com.example.patient_app.service;

import com.example.patient_app.entities.Consultation;
import com.example.patient_app.entities.Medecin;
import com.example.patient_app.entities.Patient;
import com.example.patient_app.entities.RendezVous;

public interface IHospitalServive {
    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation (Consultation consultation);

}