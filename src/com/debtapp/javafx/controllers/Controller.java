package com.debtapp.javafx.controllers;

import com.debtapp.javafx.interfaces.impl.DebtorBook;
import com.debtapp.javafx.objects.Debtor;
import com.debtapp.javafx.support.ModalCreator;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public static final ModalCreator modalCreator = ModalCreator.getInstance() ;
    public static final String ERROR_PATH = "../fxml/modal_error.fxml";
    public static final String MODAL_PATH = "../fxml/modal.fxml";
    public static final String INFO_PATH = "../fxml/modal_info.fxml";

    @FXML Button btnSearch;
    @FXML Button btnAdd;
    @FXML Button btnDelete;
    @FXML Button btnUpdate;
    @FXML TextField fieldSearch;
    @FXML TableView tableDebtorBook;
    @FXML TableColumn<Debtor, String> columnName;
    @FXML TableColumn<Debtor, String> columnPhone;
    @FXML TableColumn<Debtor, String> columnAddress;
    @FXML TableColumn<Debtor, String> columnId;
    @FXML TableColumn<Debtor, String> columnIp;
    @FXML Label lblCount;

    private Button clickedButton;
    private DebtorBook debtorBook = new DebtorBook();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnName.setCellValueFactory(new PropertyValueFactory<Debtor, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Debtor, String>("phone"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<Debtor, String>("address"));
        columnId.setCellValueFactory(new PropertyValueFactory<Debtor, String>("vkId"));
        columnIp.setCellValueFactory(new PropertyValueFactory<Debtor, String>("ip"));
        debtorBook.fillData();
        tableDebtorBook.setItems(debtorBook.getDebtors());
        debtorBook.getDebtors().addListener(new ListChangeListener<Debtor>() {
            @Override
            public void onChanged(Change<? extends Debtor> c) {
                updateCountLabel();
            }
        });
        updateCountLabel();
    }

    public void buttonPressed(ActionEvent actionEvent) {
        clickedButton = (Button) actionEvent.getSource();

        switch (clickedButton.getId()) {
            case "btnSearch" :
                if (fieldSearch.getText().isEmpty()) {
                    modalCreator.createErrorModal(actionEvent,ERROR_PATH,"Пустой поиск!");
                } else {
                    lookFor();
                }
                break;
            case "btnAdd" :
                modalCreator.createAddModal(actionEvent,MODAL_PATH);
                break;
            case "btnDelete" :
                modalCreator.createInfoModal(actionEvent,INFO_PATH, "Файл успешно удален!");
                break;
            case "btnUpdate" :
                modalCreator.createEditingModal(actionEvent, MODAL_PATH);
                break;
        }
    }

    private void lookFor() {

    }

    private void updateCountLabel() {
        lblCount.setText("Количевство записей : " + debtorBook.getDebtors().size());
    }
}
