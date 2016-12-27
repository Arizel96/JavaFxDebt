package com.debtapp.javafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Arizel on 25.12.2016.
 */
public class ModalController {
    @FXML Button btnOk;
    @FXML Button btnCancel;
    @FXML TextField fieldName;
    @FXML TextField fieldPhone;
    @FXML TextField fieldAddress;
    @FXML TextField fieldId;
    @FXML TextField fieldIp;

    private Button clickedButton;
    private Stage stage;

    public void buttonPressed(ActionEvent actionEvent) {
        clickedButton = (Button) actionEvent.getSource();
        switch (clickedButton.getId()) {
            case "btnOk" :
                if (checkEmpty()) {
                    Controller.modalCreator.createErrorModal(actionEvent, Controller.ERROR_PATH, "Заполните все пустые поля!");
                }
                break;
            case "btnCancel" :
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.close();
                break;
        }
    }

    private boolean checkEmpty() {
        return true;
    }
}
