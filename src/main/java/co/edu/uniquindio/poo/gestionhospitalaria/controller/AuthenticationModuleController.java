package co.edu.uniquindio.poo.gestionhospitalaria.controller;

import co.edu.uniquindio.poo.gestionhospitalaria.model.*;

import java.util.Map;

public class AuthenticationModuleController {

    private Hospital hospital;
    private AuthenticationModule authenticationModule;


    public AuthenticationModuleController(Hospital hospital) {
        this.hospital = hospital;
        this.authenticationModule = hospital.getAuthenticationModule();

    }

    public Person authenticate(String user, String password ) {
    return authenticationModule.authenticate(user, password);
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public AuthenticationModule getAuthenticationModule() {
        return authenticationModule;
    }

    public void setAuthenticationModule(AuthenticationModule authenticationModule) {
        this.authenticationModule = authenticationModule;
    }


}
