package co.edu.uniquindio.poo.gestionhospitalaria.viewController;

import co.edu.uniquindio.poo.gestionhospitalaria.App;
import co.edu.uniquindio.poo.gestionhospitalaria.controller.DoctorServiceController;
import javafx.fxml.FXML;

public class DoctorServiceViewController {

    private App app;
    private DoctorServiceController doctorServiceController;

    @FXML
    public void initialize() {
        doctorServiceController = new DoctorServiceController(app.hospital);
    }


    public DoctorServiceController getDoctorServiceController() {
        return doctorServiceController;
    }

    public void setDoctorServiceController(DoctorServiceController doctorServiceController) {
        this.doctorServiceController = doctorServiceController;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
