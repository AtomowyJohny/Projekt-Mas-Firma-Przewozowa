package AtomowyProjekt.Pracownicy;

import java.util.Date;

public class Dyspozytor extends Pracownik {

    public Dyspozytor(String imie, String nazwisko, long pesel, long numerTelefonu, Date dataZatrudnienia, double mnoznikWyplaty) {
        super(imie, nazwisko, pesel, numerTelefonu, dataZatrudnienia, mnoznikWyplaty);
        dodajDoEkstensji();
    }

    public Dyspozytor(String imie, String nazwisko, long pesel, Date dataZatrudnienia, double mnoznikWyplaty) {
        super(imie, nazwisko, pesel, dataZatrudnienia, mnoznikWyplaty);
        dodajDoEkstensji();
    }

    public void dodajDoEkstensji() {
        if (!areErrors())
            pracownikEkstensja.add(this);
    }

    private boolean areErrors() {
        return mnoznikWyplaty <= 0;
    }


}

