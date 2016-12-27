package com.debtapp.javafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
    @FXML Button btnSearch;
    @FXML Button btnAdd;
    @FXML Button btnDelete;
    @FXML Button btnUpdate;
    @FXML TextField fieldSearch;

    private Button clickedButton;
    private static final String ERROR_PATH = "../fxml/modal_error.fxml";
    private static final String MODAL_PATH = "../fxml/modal.fxml";
    private static final String INFO_PATH = "../fxml/modal_info.fxml";
    private static final String RANDOM = "";

    public void buttonPressed(ActionEvent actionEvent) {
        clickedButton = (Button) actionEvent.getSource();

        switch (clickedButton.getId()) {
            case "btnSearch" :
                if (fieldSearch.getText().isEmpty()) {
                    createErrorModal(actionEvent,ERROR_PATH);
                } else {
                    lookFor();
                }
                break;
            case "btnAdd" :
                createAddModal(actionEvent,MODAL_PATH);
                break;
            case "btnDelete" :
                createInfoModal(actionEvent,INFO_PATH);
                break;
            case "btnUpdate" :
                createEditingModal(actionEvent, MODAL_PATH);
                break;
        }
    }

    private void lookFor() {

    }

    private void createErrorModal(ActionEvent actionEvent, String fxmlPath) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setTitle("Ошибка");
            stage.setMinHeight(100);
            stage.setMinWidth(220);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createEditingModal(ActionEvent actionEvent, String fxmlPath) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setTitle("Редактирование Записи");
            stage.setMinHeight(190);
            stage.setMinWidth(350);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createAddModal(ActionEvent actionEvent, String fxmlPath) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setTitle("Добавление Записи");
            stage.setMinHeight(190);
            stage.setMinWidth(350);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createInfoModal(ActionEvent actionEvent, String fxmlPath) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setTitle("Отчет");
            stage.setMinHeight(100);
            stage.setMinWidth(220);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
