module com.example.advjavaassignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.advjavaassignment1 to javafx.fxml;
    exports com.example.advjavaassignment1;
}