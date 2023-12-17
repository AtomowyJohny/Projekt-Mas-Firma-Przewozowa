package AtomowyProjekt.Autobusy;

import AtomowyProjekt.Pracownicy.Dyspozytor;
import AtomowyProjekt.Pracownicy.Kierowca;
import AtomowyProjekt.Pracownicy.Mechanik;

import java.util.ArrayList;
import java.util.List;

public abstract class Autobus {
    public static List<Autobus> autobusEkstensja = new ArrayList<>();

    public String model;
    public long przebieg, mocNetto, zasieg;
    public int idAutobusu, rokProdukcji, iloscMiejsc;
    List<Dyspozytor> dyspozytorzy = new ArrayList<>();
    List<Mechanik> mechanicy = new ArrayList<>();
    List<Kierowca> kierowcy = new ArrayList<>();
    Kierowca kierowca;

    public Autobus(int idAutobusu, long przebieg, int rokProdukcji, String model, long mocNetto, long zasieg, int iloscMiejsc) {
        this.idAutobusu = idAutobusu;
        this.przebieg = przebieg;
        this.rokProdukcji = rokProdukcji;
        this.model = model;
        this.mocNetto = mocNetto;
        this.zasieg = zasieg;
        this.iloscMiejsc = iloscMiejsc;
    }

    public long przejechaneKM() {
        return this.przebieg;
    }


    public List<Dyspozytor> getDyspozytorzy() {
        return dyspozytorzy;
    }

    public List<Mechanik> getMechanicy() {
        return mechanicy;
    }

    public List<Kierowca> getKierowcy() {
        return kierowcy;
    }
}
