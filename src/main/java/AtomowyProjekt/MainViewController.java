package AtomowyProjekt;

import AtomowyProjekt.Autobusy.Autobus;
import AtomowyProjekt.Pracownicy.Dyspozytor;
import AtomowyProjekt.Pracownicy.Kierowca;
import AtomowyProjekt.Pracownicy.Mechanik;
import AtomowyProjekt.Pracownicy.Pracownik;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private Stage stage;
    private Scene scene;

    private Parent root;

    private final List<String> listaPracownikow = new ArrayList<>();
    private final List<String> listaAutobusow = new ArrayList<>();
    private final List<String> listaAutobusowPracownika = new ArrayList<>();
    private String zaznaczonyPracownik;
    private String peselZaznaczonegoPracownika;
    private String zazanaczonyAutobus;
    private String idZaznaczonyAutobus;

    private String idZaznaczonyAutobusPrzypisany;

    @FXML
    private ListView<String> pracownicyListView;
    @FXML
    private ListView<String> autobusyPracownikaListView;
    @FXML
    private ListView<String> autobusyListView;
    @FXML
    private Button przypiszAutobusButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initPracownicyListView();
        initAutobusyListView();
        initListeners();
    }

    private void initPracownicyListView() {
        for (Pracownik pracownik : Pracownik.pracownikEkstensja) {
            String danePracownika = pracownik.getClass().getSimpleName() + " " + pracownik.imie + " " + pracownik.nazwisko + " " + pracownik.pesel;
            listaPracownikow.add(danePracownika);
        }
        pracownicyListView.getItems().addAll(listaPracownikow);
    }

    private void initAutobusyListView() {
        for (Autobus autobus : Autobus.autobusEkstensja) {
            String daneAutobusu = autobus.getClass().getSimpleName() + " Id: " + autobus.idAutobusu + " Model: " + autobus.model + " Przebieg: " + autobus.przebieg;
            listaAutobusow.add(daneAutobusu);
        }
        autobusyListView.getItems().addAll(listaAutobusow);
    }

    private void initListeners() {
        pracownicyListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                zaznaczonyPracownik = pracownicyListView.getSelectionModel().getSelectedItem();
                peselZaznaczonegoPracownika = zaznaczonyPracownik.split(" ")[3];
                updateAutobusyPracownikaListView();
            }
        });

        autobusyListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                zazanaczonyAutobus = autobusyListView.getSelectionModel().getSelectedItem();
                idZaznaczonyAutobus = zazanaczonyAutobus.split(" ")[2];
            }
        });

        autobusyPracownikaListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(autobusyPracownikaListView.getSelectionModel().getSelectedItem() == null){
                    return;
                }
                idZaznaczonyAutobusPrzypisany = autobusyPracownikaListView.getSelectionModel().getSelectedItem().split(" ")[2];
            }
        });

    }

    private void updateAutobusyPracownikaListView() {
        listaAutobusowPracownika.clear();

        for (Autobus autobus : Autobus.autobusEkstensja) {
            for (Kierowca kierowca : autobus.getKierowcy()) {
                if (kierowca.getPesel() == Long.valueOf(peselZaznaczonegoPracownika)) {
                    listaAutobusowPracownika.add(autobus.getClass().getSimpleName() + " Id: " + autobus.idAutobusu + " Model: " + autobus.model + " Przebieg: " + autobus.przebieg);
                }
            }

            for (Dyspozytor dyspozytor : autobus.getDyspozytorzy()) {
                if (dyspozytor.getPesel() == Long.valueOf(peselZaznaczonegoPracownika)) {
                    listaAutobusowPracownika.add(autobus.getClass().getSimpleName() + " Id: " + autobus.idAutobusu + " Model: " + autobus.model + " Przebieg: " + autobus.przebieg);
                }
            }

            for (Mechanik mechanik : autobus.getMechanicy()) {
                if (mechanik.getPesel() == Long.valueOf(peselZaznaczonegoPracownika)) {
                    listaAutobusowPracownika.add(autobus.getClass().getSimpleName() + " Id: " + autobus.idAutobusu + " Model: " + autobus.model + " Przebieg: " + autobus.przebieg);
                }
            }
        }

        autobusyPracownikaListView.getItems().clear();
        autobusyPracownikaListView.getItems().addAll(listaAutobusowPracownika);
    }

    @FXML
    private void przypiszAutobus(ActionEvent event) {
        Autobus autobusDoPrzypisania = null;

        for (Autobus autobus : Autobus.autobusEkstensja) {
            if (autobus.idAutobusu == Integer.parseInt(idZaznaczonyAutobus)) {
                autobusDoPrzypisania = autobus;
                break;
            }
        }

        for (Pracownik pracownik : Pracownik.pracownikEkstensja) {
            if (pracownik.pesel == Long.parseLong(peselZaznaczonegoPracownika)) {
                switch (zaznaczonyPracownik.split(" ")[0].toLowerCase()) {
                    case "kierowca":
                        autobusDoPrzypisania.getKierowcy().add((Kierowca) pracownik);
                        break;
                    case "mechanik":
                        autobusDoPrzypisania.getMechanicy().add((Mechanik) pracownik);
                        break;
                    case "dyspozytor":
                        autobusDoPrzypisania.getDyspozytorzy().add((Dyspozytor) pracownik);
                        break;
                }
                break;
            }
        }

        updateAutobusyPracownikaListView();

    }

    @FXML
    private void usunPrzypisanyAutobus() {
        Autobus zaznaczonyAutobus = null;
        Pracownik wybranyPracownik = null;

        for (Autobus autobus : Autobus.autobusEkstensja) {
            if (autobus.idAutobusu == Integer.parseInt(idZaznaczonyAutobusPrzypisany)) {
                zaznaczonyAutobus = autobus;
                break;
            }
        }

        if (zaznaczonyAutobus != null) {
            for (Pracownik pracownik : Pracownik.pracownikEkstensja) {
                if (pracownik.pesel == (peselZaznaczonegoPracownika != null ? Long.parseLong(peselZaznaczonegoPracownika) : 0)) {
                    wybranyPracownik = pracownik;
                    break;
                }
            }

            if (wybranyPracownik != null) {
                switch (zaznaczonyPracownik.split(" ")[0].toLowerCase()) {
                    case "kierowca":
                        zaznaczonyAutobus.getKierowcy().remove(wybranyPracownik);
                        break;
                    case "mechanik":
                        zaznaczonyAutobus.getMechanicy().remove(wybranyPracownik);
                        break;
                    case "dyspozytor":
                        zaznaczonyAutobus.getDyspozytorzy().remove(wybranyPracownik);
                        break;
                }
            }
        }
        updateAutobusyPracownikaListView();
    }

    @FXML
    public void przelaczSceneDodawaniePracownika(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dodawaniePracownika.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
