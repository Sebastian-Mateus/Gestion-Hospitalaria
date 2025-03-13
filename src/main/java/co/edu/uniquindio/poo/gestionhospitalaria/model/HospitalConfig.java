package co.edu.uniquindio.poo.gestionhospitalaria.model;

import java.time.LocalTime;

public class HospitalConfig {
    private static HospitalConfig hospitalConfig;

    private LocalTime startBussinesHours;
    private LocalTime endBussinesHours;
    private int maxPatientsbyDoctor;
    private String billingRules;


    /**
     *
     */
    private HospitalConfig() {
        // Valores iniciales, se pueden modificar posteriormente
        this.startBussinesHours = LocalTime.of(8, 0);
        this.endBussinesHours = LocalTime.of(12, 0);
        this.maxPatientsbyDoctor = 10;
        this.billingRules= "Reglas generales de facturación";
    }

    /**
     * Static method that creates the static instace of HopitalConfig if it is null
     * @return the static instance of HospitalConfig
     */
    public static HospitalConfig getInstance() {
        if (hospitalConfig == null){
            hospitalConfig = new HospitalConfig();
        }
        return hospitalConfig;
    }



    public static HospitalConfig getHospitalConfig() {
        return hospitalConfig;
    }

    public static void setHospitalConfig(HospitalConfig hospitalConfig) {
        HospitalConfig.hospitalConfig = hospitalConfig;
    }

    public LocalTime getStartBussinesHours() {
        return startBussinesHours;
    }

    public void setStartBussinesHours(LocalTime startBussinesHours) {
        this.startBussinesHours = startBussinesHours;
    }

    public LocalTime getEndBussinesHours() {
        return endBussinesHours;
    }

    public void setEndBussinesHours(LocalTime endBussinesHours) {
        this.endBussinesHours = endBussinesHours;
    }

    public int getMaxPatientsbyDoctor() {
        return maxPatientsbyDoctor;
    }

    public void setMaxPatientsbyDoctor(int maxPatientsbyDoctor) {
        this.maxPatientsbyDoctor = maxPatientsbyDoctor;
    }

    public String getBillingRules() {
        return billingRules;
    }

    public void setBillingRules(String billingRules) {
        this.billingRules = billingRules;
    }
}
