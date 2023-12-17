package AtomowyProjekt.Autobusy.RodzajNapedu;

import AtomowyProjekt.Autobusy.Autobus;
import AtomowyProjekt.Autobusy.ZasiegKursu.AutobusMiedzymiastowy;
import AtomowyProjekt.Autobusy.ZasiegKursu.AutobusMiejski;
import AtomowyProjekt.Autobusy.ZasiegKursu.ZasiegKursu;

public class AutobusSilnikowy extends Autobus {
    enum TypPaliwa{ Benzyna, Ropa, Gaz;}

    public TypPaliwa typPaliwa;
    public ZasiegKursu zasiegKursu;

    public int iloscKoni, spalanie, pojemnoscZbiornika, iloscPaliwa;


    public AutobusSilnikowy(int idAutobusu, long przebieg, int rokProdukcji, String model, long mocNetto, long zasieg, int iloscMiejsc,
                            int iloscKoni, int spalanie, int pojemnoscZbiornika, String typPaliwa, int iloscPaliwa,
                            String miasto, boolean oznaczenieKursu) {
        super(idAutobusu, przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc);

        this.typPaliwa = przypiszTypPaliwa(typPaliwa);
        this.iloscKoni = iloscKoni;
        this.spalanie = spalanie;

        this.pojemnoscZbiornika = pojemnoscZbiornika;
        this.zasiegKursu = new AutobusMiejski(miasto, oznaczenieKursu);

        dodajDoEkstensji();
    }

    public AutobusSilnikowy(int idAutobusu, long przebieg, int rokProdukcji, String model, long mocNetto, long zasieg, int iloscMiejsc,
                            int iloscKoni, int spalanie, int pojemnoscZbiornika, String typPaliwa, int iloscPaliwa,
                            long maxOdlegloscOdZajezdni, boolean czyPozaKraj, String... listaMiast) {
        super(idAutobusu, przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc);

        this.typPaliwa = przypiszTypPaliwa(typPaliwa);
        this.iloscKoni = iloscKoni;
        this.spalanie = spalanie;

        this.pojemnoscZbiornika = pojemnoscZbiornika;
        this.zasiegKursu = new AutobusMiedzymiastowy(maxOdlegloscOdZajezdni, czyPozaKraj, listaMiast);

        dodajDoEkstensji();
    }

    private TypPaliwa przypiszTypPaliwa(String typPaliwa) {
        return switch (typPaliwa.toLowerCase()) {
            case "benzyna" -> TypPaliwa.Benzyna;
            case "ropa" -> TypPaliwa.Ropa;
            case "gaz" -> TypPaliwa.Gaz;
            default -> null;
        };
    }

    private void dodajDoEkstensji() {
        if (!areErrors())
            autobusEkstensja.add(this);
    }

    private boolean areErrors() {
        return this.typPaliwa == null;
    }

    public void zatankuj() {
        this.iloscPaliwa = this.pojemnoscZbiornika;
    }
}
