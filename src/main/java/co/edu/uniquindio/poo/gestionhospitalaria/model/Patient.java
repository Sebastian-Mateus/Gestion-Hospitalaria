package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;

public class Patient extends Person implements Prototype {

    private int age;

    private MedicalRecord medicalRecord;
    private LinkedList<Appointment> appointments;

    public Patient(String name, String id, String email, String password, int age) {
        super(name, id, email, password);
        this.age = age;

        this.appointments = new LinkedList<>();
        this.medicalRecord = new MedicalRecord(id);
    }

    @Override
    public Patient clone() {
        try {
            Patient patientCloned= (Patient) super.clone();
            patientCloned.medicalRecord = this.medicalRecord.clone();
            patientCloned.appointments = null;
            return patientCloned;
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                '}';
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public LinkedList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(LinkedList<Appointment> appointments) {
        this.appointments = appointments;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
