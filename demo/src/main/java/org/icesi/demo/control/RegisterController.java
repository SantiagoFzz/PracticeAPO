package org.icesi.demo.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField nameTextFiled;

    @FXML
    private TextField codeTextFiled;

    @FXML
    private Label listStudentsLabel;

    private StudentsController controller;




    public void onRegisterStudent(ActionEvent actionEvent){
        String name = nameTextFiled.getText();
        String code = codeTextFiled.getText();

        controller.addStudent(name, code);

        String msj = "Lista de usuarios \n" + controller.printStudents();

        listStudentsLabel.setText(msj);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new StudentsController();
    }
}