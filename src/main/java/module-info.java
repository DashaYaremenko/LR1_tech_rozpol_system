module org.example.lr1_tech_rozpol_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lr1_tech_rozpol_system to javafx.fxml;
    exports org.example.lr1_tech_rozpol_system;
}