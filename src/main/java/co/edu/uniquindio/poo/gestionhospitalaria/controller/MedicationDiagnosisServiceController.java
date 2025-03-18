package co.edu.uniquindio.poo.gestionhospitalaria.controller;

import co.edu.uniquindio.poo.gestionhospitalaria.model.*;

import java.util.LinkedList;
import java.util.Map;

public class MedicationDiagnosisServiceController {

    private Hospital hospital;
    private MedicationDiagnosisService medicationDiagnosisService;


    public MedicationDiagnosisServiceController(Hospital hospital) {
        this.hospital = hospital;
        this.medicationDiagnosisService= hospital.getMedicationDiagnosisService();

    }

    public LinkedList<Medication> getAllMedications(){
        return medicationDiagnosisService.getAllMedications();
    }

    public LinkedList<Diagnosis> getAllDiagnosis(){
        return medicationDiagnosisService.getAllDiagnoses();
    }


}
