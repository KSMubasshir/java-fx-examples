module com.example.java_street_fighter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens com.example.java_street_fighter to javafx.fxml;
    exports com.example.java_street_fighter;
}