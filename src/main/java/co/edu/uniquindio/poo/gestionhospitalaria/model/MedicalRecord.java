package co.edu.uniquindio.poo.gestionhospitalaria.model;
import java.util.LinkedList;

public class MedicalRecord implements Prototype {

    private String patientId;

    private LinkedList<MedicalRecordDetail> details;

    public MedicalRecord(String patientId) {
        this.patientId = patientId;
        this.details = new LinkedList<>();
    }

    @Override
    public MedicalRecord clone() {
        try {
            MedicalRecord recordCloned= (MedicalRecord) super.clone();
            recordCloned.details = new LinkedList<>();
            for (MedicalRecordDetail detail : this.details) {
                recordCloned.details.add(detail.clone());
            }
            return recordCloned;
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("Cloning not supported", e);
        }
    }
    public void addMedicalDetail(MedicalRecordDetail detail) {
        details.add(detail);
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LinkedList<MedicalRecordDetail> getDetails() {
        return details;
    }

    public void setDetails(LinkedList<MedicalRecordDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "patientId='" + patientId + '\'' +
                ", details=" + details +
                '}';
    }
}

