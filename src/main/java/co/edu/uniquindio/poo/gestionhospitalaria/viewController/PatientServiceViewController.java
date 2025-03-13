package co.edu.uniquindio.poo.gestionhospitalaria.viewController;

import co.edu.uniquindio.poo.gestionhospitalaria.App;
import co.edu.uniquindio.poo.gestionhospitalaria.controller.PatientServiceController;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Appointment;
import co.edu.uniquindio.poo.gestionhospitalaria.model.AppointmentStatus;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Doctor;
import co.edu.uniquindio.poo.gestionhospitalaria.model.Patient;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class PatientServiceViewController {


    @FXML
    private TextField ageTxt;

    @FXML
    private DatePicker chooseDate;

    @FXML
    private TableView<Appointment> appointmentsTable;

    @FXML
    private TableColumn<Appointment, LocalDate> dateBookAppointment;

    @FXML
    private TableColumn<Appointment, LocalDate> dateTable;

    @FXML
    private TableColumn<Appointment, String> doctorBookAppointment;

    @FXML
    private TableColumn<Appointment, String> doctorBookedAppointment;

    @FXML
    private TextField emailTxt;

    @FXML
    private TableColumn<Appointment, LocalTime> endAppointment;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField nametxt;

    @FXML
    private TableColumn<Appointment, LocalTime> startAppointment;

    @FXML
    private TableColumn<Appointment, String> startHour;

    @FXML
    private TableColumn<Appointment, AppointmentStatus> stateAppointment;


    @FXML
    private TableView <Appointment> availableAppointments;

    private App app;
    private PatientServiceController patientServiceController;
    private Patient patient;
    private ObservableList<Appointment> appointments;
    private ObservableList<Appointment> availableAppointmentsToBook;



    @FXML
    private void initialize() {
        patientServiceController = new PatientServiceController(app.hospital);

    }

    @FXML
    void logOut(ActionEvent event) {
        app.openAuthenticationModule();
    }

    @FXML
    void loadAvailableAppointments(ActionEvent event) {
        LocalDate selectedDate = chooseDate.getValue();
        if (selectedDate != null) {
            List<Appointment> availableAppointments = new LinkedList<>();
            LinkedList<Doctor> doctors = patientServiceController.getDoctorService().getDoctorsList();
            availableAppointments.addAll(patientServiceController.getAppointmentService().generateAvailableAppointments (doctors, selectedDate));

            ObservableList<Appointment> observableAppointments = FXCollections.observableList(availableAppointments);
            this.availableAppointmentsToBook = observableAppointments;
            loadAvailableAppointmentsTable();
            System.out.println("Fecha seleccionada: " + selectedDate);
        } else {
            showAlert("Atención", "No se ha seleccionado ninguna fecha.", Alert.AlertType.WARNING);
        }

    }

    void loadAvailableAppointmentsTable() {
        dateBookAppointment.setCellValueFactory(new PropertyValueFactory<>("date"));

        doctorBookAppointment.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDoctor().getName()));

        startAppointment.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endAppointment.setCellValueFactory(new PropertyValueFactory<>("endTime"));


        // Asignar la lista observable a la tabla de citas disponibles
        availableAppointments.setItems(availableAppointmentsToBook);
    }

    @FXML
    void bookAppointmet(ActionEvent event) {
        Appointment selectedAppointment = availableAppointments.getSelectionModel().getSelectedItem();
        if(selectedAppointment != null) {
            boolean booked = patientServiceController.bookAppointment(selectedAppointment, patient);
            if(booked) {
                showAlert("Atención", "La cita ha sido agendada.", Alert.AlertType.CONFIRMATION);
            }
        }else{
            showAlert("Atención", "No se ha seleccionado ninguna cita.", Alert.AlertType.WARNING);
        }


    }

        @FXML
        void cancelAppointmet(ActionEvent event) {
            Appointment selectedAppointment = appointmentsTable.getSelectionModel().getSelectedItem();
            if (selectedAppointment != null) {
                patientServiceController.completeAppointment(selectedAppointment, AppointmentStatus.CANCELED);
                updateTable(event);
            } else {
                showAlert("Atención", "No se ha seleccionado ninguna cita.", Alert.AlertType.WARNING);
            }

        }


        @FXML
        void payAppointmet(ActionEvent event) {
            Appointment selectedAppointment = appointmentsTable.getSelectionModel().getSelectedItem();
            if (selectedAppointment != null) {
                if (selectedAppointment.getStatus() == AppointmentStatus.CANCELED) {
                    showAlert("Atención", "No puede pagar una cita cancelada.", Alert.AlertType.WARNING);
                }else{
                    patientServiceController.payAppointment(selectedAppointment);
                    updateTable(event); // Refrescar la tabla para reflejar el cambio
                }

            } else {
                showAlert("Atención", "No se ha seleccionado ninguna cita.", Alert.AlertType.WARNING);
            }
        }

        @FXML
        void updateTable(ActionEvent event) {
            loadAppointments();
            //appointments.setAll(patient.getAppointments());
            appointmentsTable.refresh();

        }


        public void loadInfo(){
            idTxt.setText(patient.getId());
            nametxt.setText(patient.getName());
            emailTxt.setText(patient.getEmail());
            ageTxt.setText(String.valueOf(patient.getAge()));
        }


        public void loadAppointments(){

            dateTable.setCellValueFactory(new PropertyValueFactory<>("date"));
            doctorBookedAppointment.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().getDoctor().getName()));

            startHour.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().getStartTime() + " - " + cellData.getValue().getEndTime()));
            stateAppointment.setCellValueFactory(new PropertyValueFactory<>("status"));

            // Cargar la lista de citas en la tabla
            appointmentsTable.getItems().setAll(appointments);
        }




        public void setApp(App app) {
        this.app = app;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
            this.appointments = FXCollections.observableList(patient.getAppointments());
            loadInfo();
        }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
