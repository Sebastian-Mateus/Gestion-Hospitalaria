package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;


public class AppointmentService {

    private LinkedList<Appointment> appointments;
    private LinkedList<Appointment> availableAppointments;
    HospitalConfig hospitalConfig = HospitalConfig.getInstance();


    public AppointmentService() {
        appointments = new LinkedList<>();
        availableAppointments = new LinkedList<>();

    }

    public void paidAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.getDoctor().saveReservedAppointments(appointment);
    }

    /**
     * Method that book and appointment
     * @param appointment the appointment that is going to be booked
     * @param patient the patient of the appointment
     * @return
     */
    public boolean bookAppointment(Appointment appointment, Patient patient) {
        if(!checkAppointmetForPatient(appointment, patient)) {
            availableAppointments.remove(appointment);
            appointment.getDoctor().saveReservedAppointments(appointment);
            appointment.setPatient(patient);
            patient.getAppointments().add(appointment);
            appointment.setStatus(AppointmentStatus.UNPAID);
            return true;
        }else{
            return false;
        }

    }




    /**
     * Method that finished an appointment when it was successfully completed, or when it was cancelled
     * @param appointment the appointment to be finished
     * @param status Finished or Canceled
     * @return True if the appointment status was successfully remove from doctor's list, and it's status was changed, false it was not
     */
    public boolean completeAppointment (Appointment appointment, AppointmentStatus status) {
        try {
            appointment.getDoctor().completeAppointment(appointment);
            appointment.setStatus(status);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    /**
     * Method that verifies if a patient has a booked appointment for a certain date and hour
     * @param appointment
     * @param patient
     * @return
     */
    private boolean checkAppointmetForPatient(Appointment appointment, Patient patient) {
        for (Appointment a : patient.getAppointments()) {
            if(a.getDate().equals(appointment.getDate()) && a.getStartTime().equals(appointment.getStartTime())) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Appointment> generateAvailableAppointments(LinkedList<Doctor> doctors, LocalDate date){
        LinkedList<Appointment> available = new LinkedList<>();

        for (Doctor doctor : doctors) { // Iterar sobre todos los doctores
            LocalTime start = hospitalConfig.getStartBussinesHours();
            LocalTime end = hospitalConfig.getEndBussinesHours();
            LocalTime current = start;

            LinkedList<Appointment> reserved = doctor.getReservedAppointments();

            while (current.plusMinutes(30).compareTo(end) <= 0) {
                Appointment slot = new Appointment(doctor, date, current, current.plusMinutes(30));
                if (!isReserved(slot, reserved)) {
                    slot.setStatus(AppointmentStatus.AVAILABLE);
                    available.add(slot);
                }
                current = current.plusMinutes(30);
            }
        }

        this.availableAppointments.clear(); // Limpiar la lista antes de agregar nuevas citas
        this.availableAppointments.addAll(available); // Actualizar la lista de citas disponibles

        return available;

    }


    public boolean isReserved(Appointment appointment, LinkedList<Appointment> reserved) {
        for (Appointment a : reserved) {
            if (appointment.getDate().equals(a.getDate()) &&
                    appointment.getStartTime().equals(a.getStartTime())) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(LinkedList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public LinkedList<Appointment> getAvailableAppointments() {
        return availableAppointments;
    }

    public void setAvailableAppointments(LinkedList<Appointment> availableAppointments) {
        this.availableAppointments = availableAppointments;
    }
}
