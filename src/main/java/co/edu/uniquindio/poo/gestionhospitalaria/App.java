package co.edu.uniquindio.poo.gestionhospitalaria;

import co.edu.uniquindio.poo.gestionhospitalaria.controller.*;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Doctor;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Hospital;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Patient;
import co.edu.uniquindio.poo.gestionhospitalaria.viewController.AuthenticationModuleViewController;
import co.edu.uniquindio.poo.gestionhospitalaria.viewController.DoctorServiceViewController;
import co.edu.uniquindio.poo.gestionhospitalaria.viewController.PatientServiceViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;



public class App extends Application {


    private Stage primaryStage;
    public Hospital hospital ;
    AuthenticationModuleViewController authenticationModuleViewController;
    PatientServiceViewController patientServiceViewController;
    DoctorServiceViewController doctorServiceViewController;
    DoctorServiceController doctorServiceController;
    PatientServiceController patientServiceController;
    AuthenticationModuleController authenticationModuleController;
    MedicalRecordServiceController medicalRecordServiceController;
    MedicationDiagnosisServiceController medicationDiagnosisServiceController;


    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.hospital = new Hospital();
        doctorServiceController = new DoctorServiceController(hospital);
        patientServiceController = new PatientServiceController(hospital);
        authenticationModuleController = new AuthenticationModuleController(hospital);
        medicalRecordServiceController = new MedicalRecordServiceController(hospital);
        medicationDiagnosisServiceController = new MedicationDiagnosisServiceController(hospital);
        openAuthenticationModule();
        stage.setTitle("Mateus Industries");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    public void openAuthenticationModule() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AuthenticationModuleView.fxml"));
            Parent root = loader.load();
            authenticationModuleViewController = loader.getController();

            authenticationModuleViewController.setApp(this);
            authenticationModuleViewController.initialize(authenticationModuleController);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openPatientServiceView (Patient patient){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientServiceView.fxml"));
            Parent root = loader.load();
            patientServiceViewController = loader.getController();

            patientServiceViewController.setApp(this);
            patientServiceViewController.initialize(patientServiceController);
            patientServiceViewController.setPatient(patient);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        }catch(IOException e){
            System.out.println("❌ Error al cargar el FXML:");
            e.printStackTrace();
        }
    }

    public void openDoctorServiceView (Doctor doctor){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorServiceView.fxml"));
            Parent root = loader.load();
            doctorServiceViewController = loader.getController();

            doctorServiceViewController.setApp(this);
            doctorServiceViewController.initialize(doctorServiceController, medicalRecordServiceController, medicationDiagnosisServiceController, patientServiceController);
            doctorServiceViewController.setDoctor(doctor);

            primaryStage.setScene(new Scene (root));
        }catch(IOException e){
            System.out.println("❌ Error al cargar el FXML:");
            e.printStackTrace();
        }
    }

    public void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }


    public AuthenticationModuleController getAuthenticationModuleController() {
        return authenticationModuleController;
    }

    public void setAuthenticationModuleController(AuthenticationModuleController authenticationModuleController) {
        this.authenticationModuleController = authenticationModuleController;
    }

    public AuthenticationModuleViewController getAuthenticationModuleViewController() {
        return authenticationModuleViewController;
    }

    public void setAuthenticationModuleViewController(AuthenticationModuleViewController authenticationModuleViewController) {
        this.authenticationModuleViewController = authenticationModuleViewController;
    }

    public PatientServiceViewController getPatientServiceViewController() {
        return patientServiceViewController;
    }

    public void setPatientServiceViewController(PatientServiceViewController patientServiceViewController) {
        this.patientServiceViewController = patientServiceViewController;
    }

    public DoctorServiceController getDoctorServiceController() {
        return doctorServiceController;
    }

    public void setDoctorServiceController(DoctorServiceController doctorServiceController) {
        this.doctorServiceController = doctorServiceController;
    }

    public PatientServiceController getPatientServiceController() {
        return patientServiceController;
    }

    public void setPatientServiceController(PatientServiceController patientServiceController) {
        this.patientServiceController = patientServiceController;
    }
}