package co.edu.uniquindio.poo.gestionhospitalaria.model;

import javafx.beans.property.SimpleStringProperty;


    public class DiagnosisMedicationTableItem {

        private final String diagnosisName;
        private final String medicationName;
        private final String medicationDosage;


        public DiagnosisMedicationTableItem(String diagnosisName, String medicationName, String medicationDosage) {
            this.diagnosisName = diagnosisName;
            this.medicationName = medicationName;
            this.medicationDosage = medicationDosage;
        }

        public String getDiagnosisName() {
            return diagnosisName;
        }

        public String getMedicationName() {
            return medicationName;
        }

        public String getMedicationDosage() {
            return medicationDosage;
        }
    }

