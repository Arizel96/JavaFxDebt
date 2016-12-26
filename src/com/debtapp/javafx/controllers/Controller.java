package com.debtapp.javafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML Button btnSearch;
    @FXML Button btnAdd;
    @FXML Button btnDelete;
    @FXML Button btnUpdate;

    private Button clickedButton;

    public void buttonPressed(ActionEvent actionEvent) {
        clickedButton = (Button) actionEvent.getSource();

        switch (clickedButton.getId()) {
            case "btnSearch" :
                break;
            case "btnAdd" :
                break;
            case "btnDelete" :
                break;
            case "btnUpdate" :
                break;
        }
    }
}
