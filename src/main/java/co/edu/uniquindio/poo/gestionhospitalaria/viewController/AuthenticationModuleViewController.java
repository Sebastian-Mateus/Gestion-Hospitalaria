package co.edu.uniquindio.poo.gestionhospitalaria.viewController;

import co.edu.uniquindio.poo.gestionhospitalaria.App;
import co.edu.uniquindio.poo.gestionhospitalaria.controller.AuthenticationModuleController;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Patient;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    public void initialize() {
        authenticationModuleController = new AuthenticationModuleController(app.hospital);
    }

    public void login(ActionEvent event) {
        String userId = usertxt.getText();
        String password = passwordTxt.getText();

        // Try to authenticate the user
        Person user = authenticationModuleController.authenticate(userId, password);

        if (user != null) {
            if (user instanceof Patient) {
                // Usuario es un paciente, cargar la vista de paciente

                app.openPatientServiceView((Patient) user);
                System.out.println("Paciente encontrado");
            } else {
                // Usuario es un doctor, cargar la vista de doctor
                //loadDoctorView();
                System.out.println("Doctor encontrado");
            }
        } else {
            // Si la autenticación falla, se muestra un mensaje de error
            //showLoginError();
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
}
