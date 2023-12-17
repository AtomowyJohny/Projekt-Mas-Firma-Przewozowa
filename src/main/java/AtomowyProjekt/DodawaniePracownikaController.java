//package AtomowyProjekt;
//
//import javafx.event.Event;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class DodawaniePracownikaController implements Initializable {
//
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
//
//    @FXML
//    private TextField nazwiskoTextField;
//    @FXML
//    private TextField peselTextField;
//    @FXML
//    private TextField nrTelTextField;
//    @FXML
//    private TextField lataDoswiadczeniaTextField;
//    @FXML
//    private TextField typPrawaJazdyTextField;
//
//    @FXML
//    private ChoiceBox<String> typPracownikaChoiseBox;
//    @FXML
//    private ChoiceBox<String> lataDoswiadczeniaChoiseBox;
//    @FXML
//    private DatePicker dataZatrudnieniaDatePicker;
//
//    private String[] typPracownika = {"dyspozytor", "kierowca", "mechanik"};
//
//    private String[] lataDoswiadczenia = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        typPracownikaChoiseBox.getItems().addAll(typPracownika);
//        lataDoswiadczeniaChoiseBox.getItems().addAll(lataDoswiadczenia);
//    }
//
//    private void initListeners(){
//
//
//    }
//
//    private void dodajPracownika(){
//
//        String typPracownika = typPracownikaChoiseBox.getSelectionModel().getSelectedItem();
//
//        switch (typPracownika){
//            case "kerowca" -> System.out.println();
//        }
//
//    }
//
//    @FXML
//    public void przelaczDoMainView(Event event) throws IOException {
//
//        dodajPracownika();
//
////        Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
////        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
////        scene = new Scene(root);
////        stage.setScene(scene);
////        stage.show();
//    }
//}
package AtomowyProjekt;

import AtomowyProjekt.Pracownicy.Dyspozytor;
import AtomowyProjekt.Pracownicy.Kierowca;
import AtomowyProjekt.Pracownicy.Mechanik;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class DodawaniePracownikaController implements Initializable {

    String zaznaczonyTypPracownika;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField imieTextField;
    @FXML
    private TextField nazwiskoTextField;
    @FXML
    private TextField peselTextField;
    @FXML
    private TextField nrTelTextField;
    @FXML
    private TextField lataDoswiadczeniaTextField;
    @FXML
    private TextField typPrawaJazdyTextField;
    @FXML
    private ChoiceBox<String> typPracownikaChoiceBox;
    @FXML
    private ChoiceBox<String> lataDoswiadczeniaChoiseBox;
    @FXML
    private DatePicker dataZatrudnieniaDatePicker;
    @FXML
    private RadioButton dyspozytorRadioButton;
    @FXML
    private RadioButton kierowcaRadioButton;
    @FXML
    private RadioButton mechanikRadioButton;
    private String[] typPracownika = {"dyspozytor", "kierowca", "mechanik"};
    private String[] lataDoswiadczenia = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    String wybranyTypPracownika = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //typPracownikaChoiseBox.getItems().addAll(typPracownika);
        lataDoswiadczeniaChoiseBox.getItems().addAll(lataDoswiadczenia);

        initListeners();
    }


    private void initListeners() {
    }


    @FXML
    private void wyburTypuPracownika(ActionEvent event) {

        jakRazWybrany();

        if (kierowcaRadioButton.isSelected()) {
            lataDoswiadczeniaTextField.setDisable(false);
            typPrawaJazdyTextField.setDisable(false);
            wybranyTypPracownika = "kierowca";
        } else {
            wybranyTypPracownika = "dyspozytor";
        lataDoswiadczeniaTextField.setDisable(true);
        typPrawaJazdyTextField.setDisable(true);
        }

        if (mechanikRadioButton.isSelected()) {
            wybranyTypPracownika = "mechanik";
            lataDoswiadczeniaChoiseBox.setDisable(false);
        } else {
            lataDoswiadczeniaChoiseBox.setDisable(true);
        }
    }

    private void jakRazWybrany() {

        if (!imieTextField.isDisable()) {
            return;
        }

        imieTextField.setDisable(false);
        nazwiskoTextField.setDisable(false);
        peselTextField.setDisable(false);
        dataZatrudnieniaDatePicker.setDisable(false);
        nrTelTextField.setDisable(false);

    }


    private void dodajPracownika() {
       // String typPracownika; // = typPracownikaChoiseBox.getSelectionModel().getSelectedItem();
       // typPracownika = "mechanik";

        switch (wybranyTypPracownika) {
            case "kierowca":

                Kierowca kierowca = new Kierowca(
                        imieTextField.getText(),
                        nazwiskoTextField.getText(),
                        Long.valueOf(peselTextField.getText()),
                        Integer.valueOf(nrTelTextField.getText()),
                        new Date(),
                        1,
                        Integer.valueOf(lataDoswiadczeniaTextField.getText()),
                        typPrawaJazdyTextField.getText(),
                        0
                );

                System.out.println("Kierowca selected");
                break;
            case "dyspozytor":
                Dyspozytor dyspozytor = new Dyspozytor(
                        imieTextField.getText(),
                        nazwiskoTextField.getText(),
                        Long.valueOf(peselTextField.getText()),
                        Integer.valueOf(nrTelTextField.getText()),
                        new Date(),
                        1
                );

                System.out.println("Dyspozytor selected");
                break;
            case "mechanik":
                Mechanik mechanik = new Mechanik(
                        imieTextField.getText(),
                        nazwiskoTextField.getText(),
                        Long.valueOf(peselTextField.getText()),
                        Integer.valueOf(nrTelTextField.getText()),
                        new Date(),
                        1,
                        lataDoswiadczeniaChoiseBox.getSelectionModel().getSelectedIndex(),
                        1
                );
                System.out.println(lataDoswiadczeniaChoiseBox.getSelectionModel().getSelectedIndex() + 1);
                System.out.println("Mechanik selected");
                break;
        }
    }

    @FXML
    public void przelaczDoMainView(Event event) throws IOException {
        dodajPracownika();


        Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

