package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.util.HashMap;
import java.util.Map;

public class MedicalRecordService {

    private Map<String, MedicalRecord> medicalRecords;

    public MedicalRecordService() {
        medicalRecords = new HashMap<String, MedicalRecord>();
    }


    /**
     * Method that creates and save a medical verifying its existence
     * @param patientId The id of the patient
     * @return True if the record was created, false if it was not
     */
    public boolean createMedicalRecord(String patientId) {
        if(!hasMedicalRecord(patientId)){
            MedicalRecord medicalRecord = new MedicalRecord (patientId);
            addMedicalRecord(patientId, medicalRecord);
            return true;
         } else{
            return false;
        }

    }


    /**
     * Method that saves a medical record with the id of the patient
     * @param patientId the id of the patient, used to identify the medical record
     * @param record the medical record
     */
    public void addMedicalRecord(String patientId, MedicalRecord record) {
        medicalRecords.put(patientId, record);
    }

    public void addMedicalDetail(String id, MedicalRecordDetail detail) {
        getMedicalRecord(id).addMedicalDetail(detail);
    }

    /**
     * Method that verifies the existence of a medical record
     * @param patientId The id is used to verify it there is a medical record associated to that it
     * @return True if the key exists, false if it does not
     */
    public boolean hasMedicalRecord(String patientId) {
        return medicalRecords.containsKey(patientId);
    }

    /**
     * Method that returns a medical record of a patient
     * @param patientId The patient's id
     * @return The patient's medical record
     */
    public MedicalRecord getMedicalRecord(String patientId) {
        return medicalRecords.get(patientId);
    }

    /**
     * Method that eliminated a medical record verifying its existence
     * @param patientId the patient's id
     * @return True if the record was eliminated, false if was not, or the record does not exist
     */
    public boolean removeMedicalRecord(String patientId) {
        if(hasMedicalRecord(patientId)){
            medicalRecords.remove(patientId);
            return true;
        }else{
            return false;
        }

    }






}
