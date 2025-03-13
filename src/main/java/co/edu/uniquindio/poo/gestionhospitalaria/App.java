package co.edu.uniquindio.poo.gestionhospitalaria;

import co.edu.uniquindio.poo.gestionhospitalaria.model.Hospital;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Patient;
import co.edu.uniquindio.poo.gestionhospitalaria.viewController.AuthenticationModuleViewController;
import co.edu.uniquindio.poo.gestionhospitalaria.viewController.PatientServiceViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class App extends Application {


    private Stage primaryStage;
    public static Hospital hospital = hospital = new Hospital();
    AuthenticationModuleViewController authenticationModuleViewController;
    PatientServiceViewController patientServiceViewController;


    @Override
    public void start(Stage stage) throws IOException {

        this.primaryStage = stage;
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
            patientServiceViewController.setPatient(patient);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}