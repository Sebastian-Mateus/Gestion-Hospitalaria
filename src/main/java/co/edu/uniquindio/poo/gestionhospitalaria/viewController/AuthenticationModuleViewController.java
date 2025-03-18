package co.edu.uniquindio.poo.gestionhospitalaria.viewController;

import co.edu.uniquindio.poo.gestionhospitalaria.App;
import co.edu.uniquindio.poo.gestionhospitalaria.controller.AuthenticationModuleController;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Doctor;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Patient;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthenticationModuleViewController {
    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField usertxt;

    AuthenticationModuleController authenticationModuleController;
    private App app;

    @FXML
    public void initialize(AuthenticationModuleController authenticationModuleController) {
        this.authenticationModuleController = authenticationModuleController;
    }


    @FXML
    public void login(ActionEvent event) {
        String userId = usertxt.getText();
        String password = passwordTxt.getText();

        // Try to authenticate the user
        Person user = authenticationModuleController.authenticate(userId, password);

        if (user != null) {
            if (user instanceof Patient patient) {
                // Usuario es un paciente, cargar la vista de paciente
                app.openPatientServiceView(patient);
                System.out.println("Paciente encontrado");
            } else {
                // Usuario es un doctor, cargar la vista de doctor
                app.openDoctorServiceView((Doctor) user);
                System.out.println("Doctor encontrado");
            }
        } else {
            // Si la autenticación falla, se muestra un mensaje de error
            app.showAlert("Atención", "Usuario no encontrado", Alert.AlertType.WARNING);
            System.out.println("Usuario no encontrado");
        }
    }

    public boolean verifyUserInstance(Person user) {
        return user instanceof Patient;
    }



    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public AuthenticationModuleController getAuthenticationModuleController() {
        return authenticationModuleController;
    }

    public void setAuthenticationModuleController(AuthenticationModuleController authenticationModuleController) {
        this.authenticationModuleController = authenticationModuleController;
    }
}
