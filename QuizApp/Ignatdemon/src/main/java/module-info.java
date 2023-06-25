module com.example.ignatdemon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ignatdemon to javafx.fxml;
    exports com.example.ignatdemon;
}