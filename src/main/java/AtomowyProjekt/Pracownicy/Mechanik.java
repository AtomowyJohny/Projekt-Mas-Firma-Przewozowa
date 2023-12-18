package AtomowyProjekt.Pracownicy;

import java.util.Date;

public class Mechanik extends Pracownik {
    public int stopienDoswiadczenia, premia;
    public int dodatekDoPremiiZaDoswiadczenie;

    public Mechanik(String imie, String nazwisko, long pesel, long numerTelefonu, Date dataZatrudnienia, double mnoznikWyplaty, int stopienDoswiadczenia, int premia) {
        super(imie, nazwisko, pesel, numerTelefonu, dataZatrudnienia, mnoznikWyplaty);
        this.premia = premia;
        this.stopienDoswiadczenia = stopienDoswiadczenia;
        this.dodatekDoPremiiZaDoswiadczenie = premia * stopienDoswiadczenia;

        dodajDoEkstensji();
    }

    public Mechanik(String imie, String nazwisko, long pesel, Date dataZatrudnienia, double mnoznikWyplaty, int stopienDoswiadczenia, int premia) {
        super(imie, nazwisko, pesel, dataZatrudnienia, mnoznikWyplaty);
        this.premia = premia;
        this.stopienDoswiadczenia = stopienDoswiadczenia;
        this.dodatekDoPremiiZaDoswiadczenie = premia * stopienDoswiadczenia;

        dodajDoEkstensji();
    }

    private void dodajDoEkstensji() {
        if (!areErrors()) {
            pracownicy.add(this);
        }
    }

    private boolean areErrors() {
        return mnoznikWyplaty < 0 || stopienDoswiadczenia < 0 || stopienDoswiadczenia > 10 || premia < 0;
    }
}
