module com.example.sample {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.sample to javafx.fxml;
    exports com.example.sample;
}