package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class MedicalRecordDetail implements Prototype {

    private LocalDate date;
    private String notes;
    private LinkedList <Medication> medicationList;
    private LinkedList <Diagnosis> diagnosisList;
    private Appointment appointment;

    public MedicalRecordDetail(LocalDate date, String notes, String id, Appointment appointment) {
        this.notes = notes;
        this.date = date;
        this.appointment = appointment;
        this.medicationList = new LinkedList<>();
        this.diagnosisList = new LinkedList<>();
    }

@Override
    public MedicalRecordDetail clone(){
        try{
            MedicalRecordDetail clonedDetail = (MedicalRecordDetail) super.clone();
            clonedDetail.medicationList.addAll(this.medicationList);
            clonedDetail.diagnosisList.addAll(this.diagnosisList);
            clonedDetail.appointment = null;
            return clonedDetail;
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    public void addMedication(Medication medication){
        medicationList.add(medication);
    }

    public void addDiagnosis(Diagnosis diagnosis){
        diagnosisList.add(diagnosis);
    }


    @Override
    public String toString() {
        return "MedicalRecordDetail{" +
                "date='" + date  +
                ", medicationList=" + medicationList +
                ", diagnosisList=" + diagnosisList +
                ", appointment=" + appointment +
                '}';
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LinkedList<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(LinkedList<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public LinkedList<Diagnosis> getDiagnosisList() {
        return diagnosisList;
    }

    public void setDiagnosisList(LinkedList<Diagnosis> diagnosisList) {
        this.diagnosisList = diagnosisList;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
