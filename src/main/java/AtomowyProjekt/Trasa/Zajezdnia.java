package AtomowyProjekt.Trasa;

public class Zajezdnia extends Przystanek {
    enum RodzajZajezdni{ miejska, miedzymiastowa }
    RodzajZajezdni rodzajZajezdni;

    public Zajezdnia(Kurs kurs, String nazwa, int numer, String adres, String rodzajZajezdni) {
        super(nazwa, numer, adres);

        this.rodzajZajezdni = rodzajZajezdni.equalsIgnoreCase(RodzajZajezdni.miejska.name())? RodzajZajezdni.miejska:
                rodzajZajezdni.equalsIgnoreCase(RodzajZajezdni.miejska.name())? RodzajZajezdni.miedzymiastowa : null;
        if (this.rodzajZajezdni != null || this.numer > 1)
            System.out.println("ekstensja");
    }
}
