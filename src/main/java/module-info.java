module co.edu.uniquindio.poo.gestionhospitalaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jshell;


    opens co.edu.uniquindio.poo.gestionhospitalaria.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.gestionhospitalaria.model to javafx.base;
    exports co.edu.uniquindio.poo.gestionhospitalaria;
}