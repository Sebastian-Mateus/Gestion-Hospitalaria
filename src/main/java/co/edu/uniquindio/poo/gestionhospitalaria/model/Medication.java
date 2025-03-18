package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class Medication {

    private final String id;
    private final String name;
    private final String dosage;
    private final String laboratory;

    public Medication(String id, String name, String dosage, String laboratory) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.laboratory = laboratory;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDosage() {
        return dosage;
    }

    public String getLaboratory() {
        return laboratory;
    }

    @Override
    public String toString() {
        return name + " - " + dosage;
    }
}
