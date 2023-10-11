module com.example.advjavaassignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.advjavaassignment1 to javafx.fxml;
    exports com.example.advjavaassignment1;
}