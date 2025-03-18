package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;

public class Doctor extends Person{


    private LinkedList<Appointment> appointments;
    private LinkedList<Appointment> reservedAppointments;

    public Doctor(String name, String id, String email, String password) {
        super(name, id , email, password);
        this.appointments = new LinkedList<>();
        this.reservedAppointments = new LinkedList<>();
    }


    public void saveReservedAppointments(Appointment appointment) {
        reservedAppointments.add(appointment);
        appointments.add(appointment);
    }

    public void completeAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.FINISHED);
        reservedAppointments.remove(appointment);
    }

    public void updateInfo(String name, String email){
        this.setName(name);
        this.setEmail(email);
    }

    public void setReservedAppointments(LinkedList<Appointment> reservedAppointments) {
        this.reservedAppointments = reservedAppointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "status=" +
                ", appointments=" + appointments +
                '}';
    }

    public LinkedList<Appointment> getReservedAppointments() {
        return reservedAppointments;
    }


    public LinkedList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(LinkedList<Appointment> appointments) {
        this.appointments = appointments;
    }


}
