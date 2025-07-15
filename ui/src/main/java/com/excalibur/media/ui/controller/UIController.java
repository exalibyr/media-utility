package com.excalibur.media.ui.controller;

import com.excalibur.media.formatter.service.MediaService;
import com.excalibur.media.ui.model.FileType;
import com.excalibur.media.support.exception.OperationFailedException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.function.BiFunction;

public class UIController implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private TextField filePath;

    @FXML
    private ComboBox<String> fileType;

    @FXML
    private Label output;

    @FXML
    private CheckBox includeSubfolders;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fileType.setItems(
                FXCollections.observableList(
                        Arrays
                                .stream(FileType.values())
                                .map(FileType::getLabel)
                                .toList()
                )
        );
        this.fileType.getSelectionModel().selectFirst();
    }

    public void onPathButtonClick() {
        //TODO
    }

    public void onFormatButtonClick() {
        doCommand((path, service) -> String.format("Formatted %s files", service.renameFiles(path)));
    }

    public void onCountButtonClick() {
        doCommand((path, service) -> String.format("Found %s files", service.countFiles(path)));
    }

    public void onNumerateButtonClick() {
        doCommand((path, service) -> String.format("Numerated %s files", service.countFiles(path)));
    }

    private void doCommand(BiFunction<String, MediaService, String> f) {

        String path = filePath.getText();
        FileType type = FileType.of(fileType.getValue());

        if (type != null && path != null && !path.isBlank()) {
            try {
                this.output.setText(
                        f.apply(
                                path,
                                MediaService.forTypeWithRecursive(
                                        type.getFilenameType(),
                                        includeSubfolders.isSelected()
                                )
                        )
                );
            } catch (OperationFailedException e) {
                this.output.setText("Error");
            }
        }
    }

}