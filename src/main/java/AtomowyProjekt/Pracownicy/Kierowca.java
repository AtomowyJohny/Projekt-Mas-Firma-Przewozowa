package AtomowyProjekt.Pracownicy;

import java.util.Date;

public class Kierowca extends Pracownik {
    public int lataDoswiadczenia, karaZaOpoznienia;
    public String typPrawaJazdy;
    public double dodatekZaprzydzieloneKursy;

    public Kierowca(String imie, String nazwisko, long pesel, long numerTelefonu, Date dataZatrudnienia, double mnoznikWyplaty,
                    int lataDoswiadczenia, String typPrawaJazdy, int karaZaOpoznienia) {
        super(imie, nazwisko, pesel, numerTelefonu, dataZatrudnienia, mnoznikWyplaty);
        this.lataDoswiadczenia = lataDoswiadczenia;
        this.typPrawaJazdy = typPrawaJazdy;
        this.karaZaOpoznienia = karaZaOpoznienia;
        this.dodatekZaprzydzieloneKursy = dodatekOdLatPracy;
        dodajDoEkstensji();
    }

    public Kierowca(String imie, String nazwisko, long pesel, Date dataZatrudnienia, double mnoznikWyplaty,
                    int lataDoswiadczenia, String typPrawaJazdy, int karaZaOpoznienia) {
        super(imie, nazwisko, pesel, dataZatrudnienia, mnoznikWyplaty);
        this.lataDoswiadczenia = lataDoswiadczenia;
        this.typPrawaJazdy = typPrawaJazdy;
        this.karaZaOpoznienia = karaZaOpoznienia;
        this.dodatekZaprzydzieloneKursy = dodatekOdLatPracy;

        dodajDoEkstensji();
    }

    private void dodajDoEkstensji() {
        if (!areErrors()) {
            pracownicy.add(this);
        }
    }

    private boolean areErrors() {
        return this.lataDoswiadczenia < 0 || this.karaZaOpoznienia < 0 || this.dodatekZaprzydzieloneKursy < 0;
    }
}