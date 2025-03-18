package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;

public class Patient extends Person implements Prototype {

    private int age;
    private String lastName;
    private MedicalRecord medicalRecord;
    private LinkedList<Appointment> appointments;

    public Patient(String name, String lastName, String id, String email, String password, int age) {
        super(name, id, email, password);
        this.age = age;
        this.lastName = lastName;
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

    public void updateInfo(String name, String email, int age, String lastName) {
        super.setName(name);
        super.setEmail(email);
        this.age = age;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
