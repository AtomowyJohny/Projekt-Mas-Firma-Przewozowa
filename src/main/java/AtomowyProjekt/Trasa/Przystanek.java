package AtomowyProjekt.Trasa;

public class Przystanek {
    private int idPrzystanku;

    public String nazwa, adres;
    public int numer;

    public Przystanek(String nazwa, int numer, String adres) {
        this.nazwa = nazwa;
        this.numer = numer;
        this.adres = adres;
        if (numer > 0)
            System.out.println();
    }
}
