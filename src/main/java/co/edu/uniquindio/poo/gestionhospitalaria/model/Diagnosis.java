package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class Diagnosis {

    private final String id;
    private final String name;
    private final String description;
    private final String severity;

    public Diagnosis(String id, String name, String description, String severity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }
}
