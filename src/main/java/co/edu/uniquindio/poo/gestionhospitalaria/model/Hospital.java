package co.edu.uniquindio.poo.gestionhospitalaria.model;

public class Hospital {

    String name;
    PatientService patientService;
    DoctorService doctorService;
    AppointmentService appointmentService;
    MedicalRecordService medicalRecordService;
    HospitalConfig hospitalConfing = HospitalConfig.getInstance();
    AuthenticationModule authenticationModule ;

    public Hospital( ) {
        this.patientService = new PatientService();
        this.doctorService = new DoctorService();
        this.appointmentService = new AppointmentService();
        this.medicalRecordService = new MedicalRecordService();
        this.hospitalConfing = HospitalConfig.getHospitalConfig();
        this.authenticationModule= new AuthenticationModule();
        loadData();
    }

    public void loadData(){
        System.out.println(patientService.createPatient("Juan Perez", "1034","juan@uqvirtual","1234",23));
        System.out.println(doctorService.createDoctor("Jhon Prada","1035","jhon@uq", "12345"));

        authenticationModule.addPatient(patientService.checkPatient("1034").get());
        //System.out.prpatientService.checkPatient("1034").get().getId();
        System.out.println("1");
        authenticationModule.addDoctor(doctorService.checkDoctor("1035").get());
        System.out.println("2");

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

