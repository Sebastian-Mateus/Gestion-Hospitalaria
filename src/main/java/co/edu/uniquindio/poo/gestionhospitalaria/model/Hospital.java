package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class Hospital {

    String name;
    PatientService patientService;
    DoctorService doctorService;
    AppointmentService appointmentService;
    MedicalRecordService medicalRecordService;
    HospitalConfig hospitalConfing = HospitalConfig.getInstance();
    AuthenticationModule authenticationModule ;
    MedicationDiagnosisService medicationDiagnosisService;

    public Hospital( ) {
        this.patientService = new PatientService();
        this.doctorService = new DoctorService();
        this.appointmentService = new AppointmentService();
        this.medicalRecordService = new MedicalRecordService();
        this.hospitalConfing = HospitalConfig.getHospitalConfig();
        this.authenticationModule= new AuthenticationModule();
        this.medicationDiagnosisService = new MedicationDiagnosisService();
        loadData();
    }

    public void loadData(){
        patientService.createPatient("Juan","Perez", "1034","juan@uqvirtual","1234",23);
        doctorService.createDoctor("Jhon Prada","1035","jhon@uq", "12345");

        authenticationModule.addPatient(patientService.checkPatient("1034").get());
        authenticationModule.addDoctor(doctorService.checkDoctor("1035").get());

        medicationDiagnosisService.createDiagnosis("Diabetes", "Enfermedad crónica que afecta el metabolismo de la glucosa", "Alta");
        medicationDiagnosisService.createDiagnosis("Hipertensión", "Presión arterial elevada crónica", "Media");
        medicationDiagnosisService.createDiagnosis("Gripe", "Infección viral común", "Baja");

        medicationDiagnosisService.createMedication("Losartan", "50mg", "Genfar");
        medicationDiagnosisService.createMedication("Ibuprofeno", "400mg", "Bayer");
        medicationDiagnosisService.createMedication("Metformina", "850mg", "Merck");

    }


    public MedicationDiagnosisService getMedicationDiagnosisService() {
        return medicationDiagnosisService;
    }

    public void setMedicationDiagnosisService(MedicationDiagnosisService medicationDiagnosisService) {
        this.medicationDiagnosisService = medicationDiagnosisService;
    }

    public AuthenticationModule getAuthenticationModule() {
        return authenticationModule;
    }

    public void setAuthenticationModule(AuthenticationModule authenticationModule) {
        this.authenticationModule = authenticationModule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public MedicalRecordService getMedicalRecordService() {
        return medicalRecordService;
    }

    public void setMedicalRecordService(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    public HospitalConfig getHospitalConfing() {
        return hospitalConfing;
    }

    public void setHospitalConfing(HospitalConfig hospitalConfing) {
        this.hospitalConfing = hospitalConfing;
    }
}

