package AtomowyProjekt.Trasa;

import java.util.Date;

public class PracownikWZajezdni {
    public int idZajezdni, idPracownika;

    Date dataOd, dataDo;

    public PracownikWZajezdni(int idZajezdni, int idPracownika, Date dataOd) {
        this.idZajezdni = idZajezdni;
        this.idPracownika = idPracownika;
        this.dataOd = dataOd;
    }

    public PracownikWZajezdni(int idZajezdni, int idPracownika, Date dataOd, Date dataDo) {
        this.idZajezdni = idZajezdni;
        this.idPracownika = idPracownika;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
    }
}
