package co.edu.uniquindio.poo.gestionhospitalaria.controller;

import co.edu.uniquindio.poo.gestionhospitalaria.model.*;

import java.util.LinkedList;

public class PatientServiceController {
    private Hospital hospital;
    private PatientService patientService;
    private DoctorService doctorService;
    private AppointmentService appointmentService;
    private MedicalRecordService medicalRecordService;
    private AuthenticationModule authenticationModule;

    public PatientServiceController(Hospital hospital) {
        this.hospital = hospital;
        this.patientService = hospital.getPatientService();
        this.doctorService =hospital.getDoctorService();
        this.appointmentService = hospital.getAppointmentService();
        this.medicalRecordService = hospital.getMedicalRecordService();
        this.authenticationModule = hospital.getAuthenticationModule();
    }


    public boolean createPatient(String name, String lastName, String id, String email, String password, int age) {
        if (patientService.createPatient(name, lastName, id, email, password, age)){
            Patient  patient =  patientService.checkPatient(id).get();
            medicalRecordService.addMedicalRecord(id, patient.getMedicalRecord());
            authenticationModule.addPatient(patient);
            return true;
        }else{
            return false;
        }
    }

    public LinkedList<Patient> getVowelsPatient() {
        return patientService.getPatientsWithTwoEqualVowels();
    }
    public LinkedList<Patient> getPalindromePatients() {
        return patientService.getPatientsWithPalindromeNames();
    }
    public boolean bookAppointment(Appointment appointment, Patient patient) {
        return appointmentService.bookAppointment(appointment, patient);
    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }
    public void payAppointment(Appointment appointment) {
        appointmentService.paidAppointment(appointment);
    }
    public void completeAppointment(Appointment appointment, AppointmentStatus status) {
        appointmentService.completeAppointment(appointment, status);
    }

    public boolean deletePatient(String id) {
        return (patientService.deletePatient(id));
    }

    public Patient getPatient(String id) {
        Patient patient = patientService.checkPatient(id).orElse(null);
        return patient;
    }

    public LinkedList <Patient> getPalindromes(){
        return patientService.getPatients();
    }

    public LinkedList <Patient> getTwoVowels(){
        return patientService.getPatientsWithTwoEqualVowels();
    }

    public MedicalRecordService getMedicalRecordService() {
        return medicalRecordService;
    }

    public void setMedicalRecordService(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
