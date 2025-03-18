package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.*;

public class MedicationDiagnosisService {
    private final LinkedList<Medication> medications;
    private final LinkedList <Diagnosis> diagnoses ;

    public MedicationDiagnosisService() {
        medications = new LinkedList();
        diagnoses = new LinkedList();
    }

    // MÉTODOS PARA DIAGNOSIS

    public Diagnosis createDiagnosis(String name, String description, String severity) {
        String id = UUID.randomUUID().toString();
        Diagnosis diagnosis = new Diagnosis(id, name, description, severity);
        diagnoses.add(diagnosis);
        return diagnosis;
    }

    public Optional<Diagnosis> getDiagnosis(String id) {
        for (Diagnosis diagnosis : diagnoses) {
            if (diagnosis.getId().equals(id)) {
                return Optional.of(diagnosis);
            }
        }
        return Optional.empty();
    }

    public boolean updateDiagnosis(String id, String name, String description, String severity) {
        for (int i = 0; i < diagnoses.size(); i++) {
            if (diagnoses.get(i).getId().equals(id)) {
                diagnoses.set(i, new Diagnosis(id, name, description, severity));
                return true;
            }
        }
        return false;
    }

    public boolean deleteDiagnosis(String id) {
        for (int i = 0; i < diagnoses.size(); i++) {
            if (diagnoses.get(i).getId().equals(id)) {
                diagnoses.remove(i);
                return true;
            }
        }
        return false;
    }

    public LinkedList<Diagnosis> getAllDiagnoses() {
        return diagnoses;
    }

    // MÉTODOS PARA MEDICATION

    public Medication createMedication(String name, String dosage, String laboratory) {
        String id = UUID.randomUUID().toString();
        Medication medication = new Medication(id, name, dosage, laboratory);
        medications.add(medication);
        return medication;
    }

    public Optional<Medication> getMedication(String id) {
        for (Medication medication : medications) {
            if (medication.getId().equals(id)) {
                return Optional.of(medication);
            }
        }
        return Optional.empty();
    }

    public boolean updateMedication(String id, String name, String dosage, String laboratory) {
        for (int i = 0; i < medications.size(); i++) {
            if (medications.get(i).getId().equals(id)) {
                medications.set(i, new Medication(id, name, dosage, laboratory));
                return true;
            }
        }
        return false;
    }

    public boolean deleteMedication(String id) {
        for (int i = 0; i < medications.size(); i++) {
            if (medications.get(i).getId().equals(id)) {
                medications.remove(i);
                return true;
            }
        }
        return false;
    }

    public LinkedList <Medication> getAllMedications() {
        return medications;
    }

}
