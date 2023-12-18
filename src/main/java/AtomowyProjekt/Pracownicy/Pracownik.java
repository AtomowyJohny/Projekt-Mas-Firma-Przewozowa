package AtomowyProjekt.Pracownicy;

import AtomowyProjekt.Autobusy.Autobus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pracownik implements Firma {
//   public static List<Pracownik> pracownikEkstensja = new ArrayList<>();

    public String imie, nazwisko;
    public int wiek, dodatekOdLatPracy;
    public long pesel;
    public Date dataUrodzenia, dataZatrudnienia;
    public Long numerTelefonu = null;
    public double mnoznikWyplaty;
    public static int stawkaBazowa = 20;

    public Pracownik(String imie, String nazwisko, long pesel, long numerTelefonu, Date dataZatrudnienia, double mnoznikWyplaty) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.numerTelefonu = numerTelefonu;
        this.dataZatrudnienia = dataZatrudnienia;
        this.mnoznikWyplaty = mnoznikWyplaty;
    }

    public Pracownik(String imie, String nazwisko, long pesel, Date dataZatrudnienia, double mnoznikWyplaty) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataZatrudnienia = dataZatrudnienia;
        this.mnoznikWyplaty = mnoznikWyplaty;
    }

    public static void podniesPensje(int podwyzka) {
        stawkaBazowa += podwyzka;
    }

    public void obliczWyplate(Date dataOd) {

    }

    public void obliczWyplate(Date dataOd, Date dataDo) {

    }

    public long getPesel() {
        return pesel;
    }
}
