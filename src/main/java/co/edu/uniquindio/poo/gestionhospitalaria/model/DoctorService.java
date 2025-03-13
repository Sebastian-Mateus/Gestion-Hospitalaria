package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.LinkedList;
import java.util.Optional;

public class DoctorService {
    private LinkedList<Doctor> doctorsList;

    public DoctorService() {
         this.doctorsList= new LinkedList<Doctor>();
    }

    public boolean createDoctor(String name, String id, String email, String password){
        if(checkDoctor(id).isEmpty()){
            Doctor doctor = new Doctor(name, id, email, password);
            saveDoctor(doctor);
            return true;
        }else{
            return false;
        }
    }



    public Optional<Doctor> checkDoctor (String id){
        Optional<Doctor> doctor = Optional.empty();
        for (Doctor currentDoctor : doctorsList){
            if(currentDoctor.getId().equals(id)){
                doctor = Optional.of(currentDoctor);
                break;
            }
        }
        return doctor;
    }

    public void saveDoctor (Doctor doctor){
        doctorsList.add(doctor);
    }

    public boolean deleteDoctor (String id){
        Optional <Doctor> doctor = checkDoctor(id);
        if(doctor.isEmpty()){
            return false;
        }else{
            doctorsList.remove(doctor.get());
            return true;
        }

    }

    public LinkedList<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(LinkedList<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }
}
