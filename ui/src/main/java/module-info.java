module com.excalibur.media.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.excalibur.media.formatter;
    requires com.excalibur.media.support;

    exports com.excalibur.media.ui to javafx.graphics;

    opens com.excalibur.media.ui.controller to javafx.fxml;
}