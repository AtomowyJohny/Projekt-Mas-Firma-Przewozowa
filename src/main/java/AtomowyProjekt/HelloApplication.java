package AtomowyProjekt;

import AtomowyProjekt.Autobusy.RodzajNapedu.AutobusElektryczny;
import AtomowyProjekt.Autobusy.RodzajNapedu.AutobusSilnikowy;
import AtomowyProjekt.Pracownicy.Dyspozytor;
import AtomowyProjekt.Pracownicy.Kierowca;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainView"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();


        Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        Dyspozytor michalPolewczuk = new Dyspozytor(
                "Michal",
                "Polewczuk",
                99875833453L,
                7499229499L,
                new Date(),
                2.5
        );

        Dyspozytor michalPolewarczyk = new Dyspozytor(
                "Michal",
                "Polewarczyk",
                56783923340L,
                new Date(),
                21.37
        );

        Kierowca michalAbyszkin = new Kierowca(
                "Michal",
                "Abyszkin",
                99405343323L,
                100200300,
                new Date(),
                0.1,
                3,
                "B",
                24000
        );

        Kierowca michailGorbaczow = new Kierowca(
                "Michail",
                "Gorbaczow",
                85945039485L,
                new Date(),
                1,
                1000,
                "A",
                0
        );

        AutobusSilnikowy autobusSilnikowy1 = new AutobusSilnikowy(
                1,
                100000L,
                2020,
                "Polonez",
                200L,
                100000L,
                123,
                4000,
                200,
                1000,
                "Gaz",
                10000,
                "Warszawa",
                false
        );

        AutobusSilnikowy autobusSilnikowy2 = new AutobusSilnikowy(
                2,
                200L,
                1410,
                "Grunwaldzki czolg przeciwmieczny",
                1L,
                100L,
                1,
                1,
                1,
                0,
                "Benzyna",
                1,
                "Grunwald",
                true
        );

        AutobusSilnikowy autobusSilnikowy3 = new AutobusSilnikowy(
                3,
                1000L,
                2023,
                "Nie mam juz pomyslow xD",
                10000L,
                20000000000L,
                2000,
                100000,
                1490,
                2311,
                "Ropa",
                1000000,
                100000000L,
                true,
                "Warszawa", "Poznan", "Watykan", "Sri Dzajawardanapura Kotte", "Bandar Seri Begawan"
        );

        AutobusElektryczny autobusElektryczny1 = new AutobusElektryczny(
                4,
                100000L,
                2012,
                "Volvo s60",
                1000000000L,
                10000000000000L,
                4,
                22,
                22,
                2222222222L,
                false,
                "Szczecin", "Wadowice", "Bydgoszcz"
        );

        AutobusElektryczny autobusElektryczny2 = new AutobusElektryczny(
                5,
                222222L,
                2212,
                "Syrena",
                222222222222L,
                2222222222222222222L,
                222,
                222,
                2,
                "Moszna",
                false
        );

        autobusSilnikowy1.getKierowcy().add(michalAbyszkin);
        autobusSilnikowy2.getKierowcy().add(michalAbyszkin);
        autobusSilnikowy3.getKierowcy().add(michalAbyszkin);

        autobusElektryczny1.getDyspozytorzy().add(michalPolewarczyk);



        launch(args);


        //System.exit(1337);
    }
}