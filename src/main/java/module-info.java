module atomowyprojekt.firmaprzewozowa {
    requires javafx.controls;
    requires javafx.fxml;


    opens AtomowyProjekt to javafx.fxml;
    exports AtomowyProjekt;
}