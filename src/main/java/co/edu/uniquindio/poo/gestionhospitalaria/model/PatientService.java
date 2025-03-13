package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;
import java.util.Optional;

public class PatientService {

    private LinkedList<Patient> patientsList;

    public PatientService() {
        this.patientsList = new LinkedList<>();
    }

    public boolean createPatient(String name, String id, String email, String password, int age ) {
        if (checkPatient(id).isEmpty()) {
            Patient newPatient = new Patient (name, id, email, password, age);
            savePatient(newPatient);
            return true;
        }else{
            return false;
        }
    }


    private void savePatient(Patient patient) {
        patientsList.add(patient);

    }

    public Optional<Patient> checkPatient(String id) {
        Optional<Patient> patient = Optional.empty();
        for (Patient currentPatient : patientsList) {
            if (currentPatient.getId().equals(id)) {
                patient = Optional.of(currentPatient);
                break;
            }
        }
        return patient;
    }

    public boolean deletePatient(String id) {
        Optional<Patient> patient = checkPatient(id);
        if (patient.isPresent()) {
            patientsList.remove(patient.get());
            return true;
        }else{
            return false;
        }
    }

    public LinkedList<Patient> getPatients() {
        return patientsList;
    }

    public void setPatients(LinkedList<Patient> patients) {
        this.patientsList = patients;
    }
}
