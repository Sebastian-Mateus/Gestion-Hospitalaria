package co.edu.uniquindio.poo.gestionhospitalaria.viewController;

import co.edu.uniquindio.poo.gestionhospitalaria.App;
import co.edu.uniquindio.poo.gestionhospitalaria.controller.DoctorServiceController;
import co.edu.uniquindio.poo.gestionhospitalaria.controller.MedicalRecordServiceController;
import co.edu.uniquindio.poo.gestionhospitalaria.controller.MedicationDiagnosisServiceController;
import co.edu.uniquindio.poo.gestionhospitalaria.controller.PatientServiceController;
import co.edu.uniquindio.poo.gestionhospitalaria.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.jshell.Diag;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public class DoctorServiceViewController {

    private App app;
    private DoctorServiceController doctorServiceController;
    private MedicationDiagnosisServiceController medicationDiagnosisServiceController;
    private MedicalRecordServiceController medicalRecordServiceController;
    private PatientServiceController patientServiceController;
    private Doctor doctor;
    private ObservableList<Appointment> doctorAppointments;
    private LinkedList <Medication>  medications;
    private LinkedList <Diagnosis> diagnoses;
    private Appointment appointment;
    private Patient patientToDeleteUpdate;
    private Doctor doctorToDeleteUpdate;

    @FXML
    public void initialize(DoctorServiceController doctorServiceController,
                           MedicalRecordServiceController medicalRecordServiceController
    , MedicationDiagnosisServiceController medicationDiagnosisServiceController, PatientServiceController patientServiceController) {
        this.medications = new LinkedList<>();
        this.diagnoses = new LinkedList<>();
        this.doctorServiceController = doctorServiceController;
        this.medicalRecordServiceController = medicalRecordServiceController;
        this.medicationDiagnosisServiceController = medicationDiagnosisServiceController;
        this.patientServiceController = patientServiceController;
        setMoreTable();
    }

    @FXML
    private Tab appointmentsTap;

    @FXML
    private TabPane medicalServiceTabPane;

    @FXML
    private TextField ageDoctorTxt1;

    @FXML
    private TextField agePatientTxt;

    @FXML
    private TextField agePatientTxt1;

    @FXML
    private TableView<Appointment> appointmentsTable;

    @FXML
    private TableColumn<Appointment, String> dateTable;

    @FXML
    private TextField dateTxt1;

    @FXML
    private TableView<DiagnosisMedicationTableItem> detailsRecord;

    @FXML
    private TableColumn<DiagnosisMedicationTableItem, String> diagnosisDetail;

    @FXML
    private TableColumn<DiagnosisMedicationTableItem, String> dosisDetail;

    @FXML
    private TextField emailDoctorTxt;

    @FXML
    private TextField emailDoctorTxt1;

    @FXML
    private TextField emailPatientTxt;

    @FXML
    private TextField emailPatientTxt1;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField hourTxt1;

    @FXML
    private TextField idDoctorTxt;

    @FXML
    private TextField idDoctorTxt1;

    @FXML
    private TextField idPatientAppointTxt1;

    @FXML
    private TextField idPatientTxt;

    @FXML
    private TextField idPatientTxt1;

    @FXML
    private TextField idTxt;

    @FXML
    private TableColumn<DiagnosisMedicationTableItem, String> medicationDetail;

    @FXML
    private TextField nameDoctorTxt;

    @FXML
    private TextField nameDoctorTxt1;

    @FXML
    private TextField namePatientTxt;

    @FXML
    private TextField lastNamePatientTxt1;

    @FXML
    private TextField namePatientTxt1;

    @FXML
    private TextField lastNamePatient;

    @FXML
    private TextField nametxt;

    @FXML
    private TextArea notes;

    @FXML
    private TextField passwordDoctorTxt;

    @FXML
    private TextField passwordPatientTxt;

    @FXML
    private TextField patientAppointTxt;

    @FXML
    private TableColumn<Appointment, String> patientBookedAppointment;

    @FXML
    private ComboBox<Diagnosis> selectDiagnosis;

    @FXML
    private ComboBox<Medication> selectMedication;

    @FXML
    private TableColumn<Appointment, String> startHour;


    @FXML
    private TableColumn<Patient, String> morePatientLastName;

    @FXML
    private TableColumn<Patient, String> morePatientName;

    @FXML
    private TableView<Patient> morePatientsTable;

    @FXML
    private TableColumn<Patient, String> idPatientMore;



    @FXML
    void getPalindromes(ActionEvent event) {
        ObservableList<Patient> palindromePatients =FXCollections.observableArrayList();

        palindromePatients.addAll(patientServiceController.getPalindromePatients());
        morePatientsTable.setItems(palindromePatients);
    }

    @FXML
    void getVowels(ActionEvent event) {
        ObservableList<Patient> vowelsPatients =FXCollections.observableArrayList();
        vowelsPatients.addAll(patientServiceController.getVowelsPatient());
        morePatientsTable.setItems(vowelsPatients);
    }


    public void setMoreTable() {
        morePatientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        morePatientLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        idPatientMore.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @FXML
    void deleteDiagnosisMedication(ActionEvent event) {
        DiagnosisMedicationTableItem selectedItem = detailsRecord.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            detailsRecord.getItems().remove(selectedItem); // Se eliminan y la tabla se reajusta automáticamente
        } else {
            app.showAlert("Atención","Debe seleccionar un diangostico y medicamento.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void addMedicationDiagnosis(ActionEvent event) {
        loadDetailsRecord();
        Diagnosis selectedDiagnosis = selectDiagnosis.getSelectionModel().getSelectedItem();
        Medication selectedMedication = selectMedication.getSelectionModel().getSelectedItem();

        if (selectedDiagnosis != null && selectedMedication != null) {
            medications.add(selectedMedication);
            diagnoses.add(selectedDiagnosis);
            DiagnosisMedicationTableItem item = new DiagnosisMedicationTableItem(
                    selectedDiagnosis.getName(),
                    selectedMedication.getName(),
                    selectedMedication.getDosage()
            );
            detailsRecord.getItems().add(item);
            }
    }

    public void loadDetailsRecord(){
        diagnosisDetail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiagnosisName()));
        medicationDetail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMedicationName()));
        dosisDetail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMedicationDosage()));

    }

    public void clearDetailsRecord(){
        patientAppointTxt.clear();
        idPatientTxt.clear();
        hourTxt1.clear();
        dateTxt1.clear();
        notes.clear();
        detailsRecord.getItems().clear();
    }



    @FXML
    void completeAppointment(ActionEvent event) {
        doctor.completeAppointment(appointment);
        MedicalRecordDetail detail = new MedicalRecordDetail(appointment.getDate(), notes.getText(), idPatientAppointTxt1.getText(), appointment);
        medicalRecordServiceController.addMedicalDetail(idPatientAppointTxt1.getText(), detail);
        clearDetailsRecord();
        app.showAlert("Atención", "La cita fue completada", Alert.AlertType.INFORMATION);
        /*
        try {
            doctor.completeAppointment(appointment);
            MedicalRecordDetail detail = new MedicalRecordDetail(appointment.getDate(), notes.getText(), idPatientAppointTxt1.getText(), appointment);
            medicalRecordServiceController.addMedicalDetail(idPatientAppointTxt1.getText(), detail);
            clearDetailsRecord();
            app.showAlert("Atención", "La cita fue completada", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            app.showAlert("Atención", "Alguno de los datos es erroneo", Alert.AlertType.ERROR);
        }

         */
    }

    @FXML
    void updateDoctor(ActionEvent event) {
        String id=idDoctorTxt1.getText();
        String name=nameDoctorTxt1.getText();
        String email=emailDoctorTxt1.getText();
        if (id!=null && name!=null && email!=null) {
            doctorToDeleteUpdate.updateInfo(name, email);
            app.showAlert("Atención", "Actualización exitosa", Alert.AlertType.INFORMATION);
            clearUpdateDoctor();
        }
    }

    public void clearUpdateDoctor() {
        idDoctorTxt1.clear();
        nameDoctorTxt1.clear();
        emailDoctorTxt1.clear();
    }


    @FXML
    void searchDoctor(ActionEvent event) {
        String id=idDoctorTxt1.getText();
        if (id!=null){
            Doctor doctor = doctorServiceController.getDoctor(id);
            if (doctor!=null){
                this.doctorToDeleteUpdate =doctor;
                loadDoctorSearch();
            }else{
                app.showAlert("Atención","No se ha encontrado un paciente con la identificación proporcionada.", Alert.AlertType.ERROR);
            }
        }else{
            app.showAlert("Atención","Debe proporcionar una identificacion.", Alert.AlertType.WARNING);
        }

    }

    public void loadDoctorSearch(){
        nameDoctorTxt1.setText(doctorToDeleteUpdate.getName());
        emailDoctorTxt1.setText(doctorToDeleteUpdate.getEmail());
    }

    @FXML
    void deleteDoctor(ActionEvent event) {
        String id=idDoctorTxt1.getText();
        if (id!=null){
           if(doctorServiceController.deleteDoctor(id)){
               app.showAlert("Atención","El médico ha sido eliminado con exito", Alert.AlertType.WARNING);
               clearUpdateDoctor();
           }else{
               app.showAlert("Atención","No se ha econtrado un médico con la identificación proporcionada", Alert.AlertType.WARNING);
           }
        }else{
            app.showAlert("Atención","Debe proporcionar una identificación", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void createDoctor(ActionEvent event) {
        String name = nameDoctorTxt.getText();
        String id = idDoctorTxt.getText();
        String email = emailDoctorTxt.getText();
        String password = passwordDoctorTxt.getText();
        if (name != null && id != null && email != null && password != null) {
            if (doctorServiceController.createDoctor(name, id, email, password)){
                app.showAlert("Atención","El doctor ha sido creado con exito", Alert.AlertType.INFORMATION);
                clearCreateDoctor();
            }else{
                app.showAlert("Atención","Ya existe un usuario con la identificación proporcionada.", Alert.AlertType.ERROR);
                clearCreateDoctor();
            }
        }else{
            app.showAlert("Atención", "Debe llenar todos los campos", Alert.AlertType.WARNING);
        }

    }

    public void clearCreateDoctor(){
        nameDoctorTxt.clear();
        idDoctorTxt.clear();
        emailDoctorTxt.clear();
        passwordDoctorTxt.clear();
    }



    @FXML
    void createPatient(ActionEvent event) {

        String name = namePatientTxt.getText();
        String lastName = lastNamePatient.getText();
        String id = idPatientTxt.getText();
        int age = Integer.parseInt(agePatientTxt.getText());
        String email = emailPatientTxt.getText();
        String password = passwordPatientTxt.getText();
        if (name != null && id != null && email != null && password != null) {
            if (patientServiceController.createPatient(name, lastName, id, email, password, age)){
                clearCreatePatient();
                app.showAlert("Atención","El paciente ha sido creado con exito", Alert.AlertType.INFORMATION);
            }else{
                app.showAlert("Atención","Ya existe un usuario con la identificación proporcionada.", Alert.AlertType.ERROR);
            }
        }else{
            app.showAlert("Atención", "Debe llenar todos los campos", Alert.AlertType.WARNING);
        }
    }

    public void clearCreatePatient(){
        namePatientTxt.clear();
        lastNamePatient.clear();
        idPatientTxt.clear();
        agePatientTxt.clear();
        emailPatientTxt.clear();
        passwordPatientTxt.clear();
    }


    @FXML
    void deletePatient(ActionEvent event) {
        String id = idPatientTxt1.getText();
        if (id != null) {
            if(patientServiceController.deletePatient(id)){
                app.showAlert("Atención","El paciente ha sido eliminado con exito", Alert.AlertType.WARNING);
                clearUpdatePatient();

            }else{
                app.showAlert("Atención","No se ha encontrado un paciente con la identificación proporcioa", Alert.AlertType.ERROR);
            }
        }else{
            app.showAlert("Atención","Debe proporcionar una identificación", Alert.AlertType.WARNING);
        }
    }


    @FXML
    void logOut(ActionEvent event) {
        app.openAuthenticationModule();
    }


    @FXML
    void updatePatient(ActionEvent event) {
        String name = namePatientTxt1.getText();
        int age = Integer.parseInt(agePatientTxt1.getText());
        String email =emailPatientTxt1.getText();
        String lastName =lastNamePatientTxt1.getText();
        if (name != null && age > 0 && email != null && name != null && lastName != null) {
            patientToDeleteUpdate.updateInfo(name, email, age, lastName);
            app.showAlert("Atención", "Actualización exitosa", Alert.AlertType.INFORMATION);
            clearUpdatePatient();
        }else{
            app.showAlert("Atención", "Debe proporcionar una identificación", Alert.AlertType.WARNING);
        }
    }

    public void clearUpdatePatient(){
        namePatientTxt1.clear();
        lastNamePatientTxt1.clear();
        idPatientTxt1.clear();
        agePatientTxt1.clear();
        emailPatientTxt1.clear();
    }

    @FXML
    void searchPatient(ActionEvent event) {
        String id = idPatientTxt1.getText();
        if (id != null) {
            Patient patient = patientServiceController.getPatient(id);
            if (patient != null) {
                this.patientToDeleteUpdate=patient;
                loadPatientSearch();
            }else{
                app.showAlert("Atención","No se ha encontrado un paciente con la identificación proporcionada.", Alert.AlertType.ERROR);
            }
        }else{
            app.showAlert("Atención","Debe proporcionar una identificación", Alert.AlertType.WARNING);
        }
    }
    public void loadPatientSearch(){
        namePatientTxt1.setText(patientToDeleteUpdate.getName());
        lastNamePatientTxt1.setText(patientToDeleteUpdate.getLastName());
        agePatientTxt1.setText(String.valueOf(patientToDeleteUpdate.getAge()));
        emailPatientTxt1.setText(patientToDeleteUpdate.getEmail());
    }


    @FXML
    void start(ActionEvent event) {
        Appointment startedAppointment = appointmentsTable.getSelectionModel().getSelectedItem();
        if(startedAppointment != null) {
            medicalServiceTabPane.getSelectionModel().select(appointmentsTap);
            setAppointment(startedAppointment);
            loadAppointmentInfo();
            loadDiagnosis();
            loadMedications();
        }else{
            app.showAlert("Atención", "No se ha seleccionado ninguna cita.", Alert.AlertType.WARNING);
        }
    }

    public void loadAppointmentInfo() {
        patientAppointTxt.setText(appointment.getPatient().getName());
        idPatientAppointTxt1.setText(appointment.getPatient().getId());
        hourTxt1.setText(appointment.getStartTime() + " - " + appointment.getEndTime());
        dateTxt1.setText(appointment.getDate().toString());
    }

    public void loadMedications(){
        ObservableList<Medication> medications = FXCollections.observableList(medicationDiagnosisServiceController.getAllMedications());
        selectMedication.setItems(medications);
    }

    public void loadDiagnosis(){
        ObservableList<Diagnosis> diagnoses = FXCollections.observableList(medicationDiagnosisServiceController.getAllDiagnosis());
        selectDiagnosis.setItems(diagnoses);
    }





    @FXML
    void updateTable(ActionEvent event) {
        loadDoctorAppointmentsTable();
        appointmentsTable.refresh();
    }

    public void loadDoctorAppointmentsTable() {
        dateTable.setCellValueFactory(cellData ->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formatedDate = cellData.getValue().getDate().format(formatter);
            return new SimpleStringProperty(formatedDate);
        });

        startHour.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStartTime() + " - " + cellData.getValue().getEndTime()));

        patientBookedAppointment.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPatient().getName()));

        appointmentsTable.setItems(doctorAppointments);
    }

    public void loadInfo(){
        nametxt.setText(doctor.getName());
        idTxt.setText(doctor.getId());
        emailTxt.setText(doctor.getEmail());
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
        this.doctorAppointments = FXCollections.observableList(doctor.getReservedAppointments());
        loadInfo();
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public DoctorServiceController getDoctorServiceController() {
        return doctorServiceController;
    }

    public void setDoctorServiceController(DoctorServiceController doctorServiceController) {
        this.doctorServiceController = doctorServiceController;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
