package com.example.patient_app;

import com.example.patient_app.entities.*;
import com.example.patient_app.repositories.ConsultationRepository;
import com.example.patient_app.repositories.MedecinRepository;
import com.example.patient_app.repositories.PatientRepository;
import com.example.patient_app.repositories.RendezVousRepository;
import com.example.patient_app.service.IHospitalServive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalServive hospitalServive,PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository)
    {
        return args -> {
            Stream.of("Sara","Omar","Salma","Aya")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalServive.savePatient(patient);

                    });
            Stream.of("Mohamed","Omar","Hanane","Layla")
                    .forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialiste(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalServive.saveMedecin(medecin);

                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Sara");


            Medecin medecin =medecinRepository.findByNom("Omar");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV = hospitalServive.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());


            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation.......");
            hospitalServive.saveConsultation(consultation);




        };
    }

}