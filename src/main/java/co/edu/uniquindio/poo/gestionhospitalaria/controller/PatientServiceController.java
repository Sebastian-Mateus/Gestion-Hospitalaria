package co.edu.uniquindio.poo.gestionhospitalaria.controller;

import co.edu.uniquindio.poo.gestionhospitalaria.model.*;

public class PatientServiceController {
    private Hospital hospital;
    private PatientService patientService;
    private DoctorService doctorService;
    private AppointmentService appointmentService;

    public PatientServiceController(Hospital hospital) {
        this.hospital = hospital;
        this.patientService = hospital.getPatientService();
        this.doctorService =hospital.getDoctorService();
        this.appointmentService = hospital.getAppointmentService();
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
