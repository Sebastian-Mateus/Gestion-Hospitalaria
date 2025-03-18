package co.edu.uniquindio.poo.gestionhospitalaria.controller;

import co.edu.uniquindio.poo.gestionhospitalaria.model.Hospital;
import co.edu.uniquindio.poo.gestionhospitalaria.model.MedicalRecord;
import co.edu.uniquindio.poo.gestionhospitalaria.model.MedicalRecordDetail;
import co.edu.uniquindio.poo.gestionhospitalaria.model.MedicalRecordService;

import java.util.Map;

public class MedicalRecordServiceController {

    private Hospital hospital;
    private MedicalRecordService medicalRecordService;
    private Map<String, MedicalRecord> medicalRecords;

    public MedicalRecordServiceController(Hospital hospital) {
        this.hospital = hospital;
        this.medicalRecordService = hospital.getMedicalRecordService();
    }

    public MedicalRecord getMedicalRecord(String id) {
        return medicalRecordService.getMedicalRecord(id);
    }

    public void addMedicalDetail(String id, MedicalRecordDetail detail) {
        medicalRecordService.addMedicalDetail(id, detail);
    }
}
