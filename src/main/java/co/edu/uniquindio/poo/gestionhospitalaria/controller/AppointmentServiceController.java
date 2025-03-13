package co.edu.uniquindio.poo.gestionhospitalaria.controller;

import co.edu.uniquindio.poo.gestionhospitalaria.model.Appointment;
import co.edu.uniquindio.poo.gestionhospitalaria.model.AppointmentService;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Hospital;

public class AppointmentServiceController {

    private Hospital hospital;
    private AppointmentService appointmentService;

    public AppointmentServiceController(Hospital hospital) {
        this.hospital = hospital;
        this.appointmentService = (hospital.getAppointmentService());
    }



}
