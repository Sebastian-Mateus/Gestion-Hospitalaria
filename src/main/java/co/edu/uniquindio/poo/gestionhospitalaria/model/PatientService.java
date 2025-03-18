package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;
import java.util.Optional;



public class PatientService {

    private LinkedList<Patient> patientsList;

    public PatientService() {
        this.patientsList = new LinkedList<>();
    }



    public LinkedList<Patient> getPatientsWithPalindromeNames() {
        LinkedList<Patient> palindromePatients = new LinkedList<>();
        for (Patient patient : patientsList) {
            if (isPalindrome(patient.getName())) {
                palindromePatients.add(patient);
            }
        }
        for (Patient patient : palindromePatients) {
            System.out.println(patient.getName());
        }
        return palindromePatients;
    }

    private boolean isPalindrome(String name) {
        String clean = name.replaceAll("\\s+", "").toLowerCase();
        int inicio = 0;
        int fin = clean.length() - 1;
        while (inicio < fin) {
            if (clean.charAt(inicio) != clean.charAt(fin)) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }

    public LinkedList<Patient> getPatientsWithTwoEqualVowels() {
        LinkedList<Patient> patientsWithVowels = new LinkedList<>();
        for (Patient patient : patientsList) {
            if (hasTwoEqualVowels(patient.getName())) {
                patientsWithVowels.add(patient);
                System.out.println(patient.getName());
            }
        }
        for(Patient patient : patientsWithVowels) {
            System.out.println(patient.getName());
        }
        return patientsWithVowels;
    }

    private boolean hasTwoEqualVowels(String name) {
        String limpio = name.toLowerCase().replaceAll("\\s+", "");

        // Arreglo para contar las vocales ('a', 'e', 'i', 'o', 'u')
        int[] conteoVocales = new int[5];

        // Recorremos el nombre y contamos las vocales
        for (char c : limpio.toCharArray()) {
            switch (c) {
                case 'a': conteoVocales[0]++; break;
                case 'e': conteoVocales[1]++; break;
                case 'i': conteoVocales[2]++; break;
                case 'o': conteoVocales[3]++; break;
                case 'u': conteoVocales[4]++; break;
            }
        }

        // Verificamos si alguna vocal tiene más de una aparición
        for (int conteo : conteoVocales) {
            if (conteo > 1) {
                return true; // Hay al menos dos vocales iguales
            }
        }

        return false; // No hay vocales repetidas
    }


    public boolean createPatient(String name, String lastName, String id, String email, String password, int age ) {
        if (checkPatient(id).isEmpty()) {
            Patient newPatient = new Patient (name, lastName, id, email, password, age);
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
