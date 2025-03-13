package co.edu.uniquindio.poo.gestionhospitalaria.controller;

import co.edu.uniquindio.poo.gestionhospitalaria.model.Doctor;
import co.edu.uniquindio.poo.gestionhospitalaria.model.DoctorService;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Hospital;

import java.util.LinkedList;

public class DoctorServiceController {

    private Hospital hospital;
    private DoctorService doctorService;

    public DoctorServiceController(Hospital hospital) {
        this.hospital = hospital;
        this.doctorService = hospital.getDoctorService();
    }

    public LinkedList<Doctor> getDoctors(){
        return doctorService.getDoctorsList();
    }
}
