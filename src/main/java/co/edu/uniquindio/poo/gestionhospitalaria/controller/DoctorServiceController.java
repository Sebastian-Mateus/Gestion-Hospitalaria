package co.edu.uniquindio.poo.gestionhospitalaria.controller;

import co.edu.uniquindio.poo.gestionhospitalaria.model.*;

import java.util.LinkedList;

public class DoctorServiceController {

    private Hospital hospital;
    private DoctorService doctorService;
    private AuthenticationModule authenticationModule;

    public DoctorServiceController(Hospital hospital) {
        this.hospital = hospital;
        this.doctorService = hospital.getDoctorService();
        this.authenticationModule = hospital.getAuthenticationModule();
    }

    public boolean createDoctor(String name,  String id, String email, String password) {
        if (doctorService.createDoctor(name, id, email, password)){
            Doctor doctor =  doctorService.checkDoctor(id).get();
            authenticationModule.addDoctor(doctor);
            return true;
        }else{
            return false;
        }
    }

    public Doctor getDoctor(String id) {
        Doctor doctor = doctorService.checkDoctor(id).orElse(null);
        return doctor;
    }

    public boolean deleteDoctor(String id) {
        return doctorService.deleteDoctor(id);
    }


    public LinkedList<Doctor> getDoctors(){
        return doctorService.getDoctorsList();
    }

    public void completeAppointment(Appointment appointment) {
    }
}
