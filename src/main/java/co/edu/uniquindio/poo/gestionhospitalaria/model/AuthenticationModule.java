package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.HashMap;
import java.util.Map;


public class AuthenticationModule {

    private Map<String, Patient> patientsCredentials;
    private Map<String, Doctor> doctorsCredentials;

    public AuthenticationModule() {
        patientsCredentials = new HashMap<String, Patient>();
        doctorsCredentials = new HashMap<String, Doctor>();
    }


    public Person authenticate(String user, String password) {
        // Verificar en pacientes
        if (patientsCredentials.containsKey(password)) {
            if (patientsCredentials.get(user).getId().equals(user)) {
                return patientsCredentials.get(password);
            }
        }
        // Verificar en doctores (si también deseas autenticar doctores)

        if (doctorsCredentials.containsKey(password)) {
            Doctor doctor = doctorsCredentials.get(password);
            if (doctor.getId().equals(user)) {
                return doctor;
            }
        }
        // Si no se encuentra o la contraseña no coincide, se retorna null
        return null;
    }

    public boolean addPatient(Patient patient) {
        if(!hasCredentialsPatients(patient)){
        patientsCredentials.put(patient.getPassword(), patient);
        System.out.println("3");
        return true;
    }else{
            System.out.println("5");
            return false;
        }
    }

    public boolean hasCredentialsPatients(Patient patient) {
        return patientsCredentials.containsKey(patient.getPassword());
    }

    public boolean addDoctor(Doctor doctor) {
        if(!hasCredentialsDoctors(doctor)){
            doctorsCredentials.put(doctor.getPassword(), doctor);
            return true;
        }else{
            return false;
        }
    }


    public boolean hasCredentialsDoctors(Doctor doctor) {
        return doctorsCredentials.containsKey(doctor.getPassword());
    }


    @Override
    public String toString() {
        return "AuthenticationModule{" +
                "patientsCredentials=" + patientsCredentials +
                ", doctorsCredentials=" + doctorsCredentials +
                '}';
    }

    public Map<String, Patient> getPatientsCredentials() {
        return patientsCredentials;
    }

    public void setPatientsCredentials(Map<String, Patient> patientsCredentials) {
        this.patientsCredentials = patientsCredentials;
    }

    public Map<String, Doctor> getDoctorsCredentials() {
        return doctorsCredentials;
    }

    public void setDoctorsCredentials(Map<String, Doctor> doctorsCredentials) {
        this.doctorsCredentials = doctorsCredentials;
    }
}
