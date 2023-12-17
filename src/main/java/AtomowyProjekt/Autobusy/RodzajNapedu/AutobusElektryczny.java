package AtomowyProjekt.Autobusy.RodzajNapedu;

import AtomowyProjekt.Autobusy.Autobus;
import AtomowyProjekt.Autobusy.ZasiegKursu.AutobusMiedzymiastowy;
import AtomowyProjekt.Autobusy.ZasiegKursu.AutobusMiejski;
import AtomowyProjekt.Autobusy.ZasiegKursu.ZasiegKursu;

public class AutobusElektryczny extends Autobus {
    public int iloscPakietowZasilajacych, poziomNaladowania;
    ZasiegKursu zasiegKursu;

    public AutobusElektryczny(int idAutobusu, long przebieg, int rokProdukcji, String model, long mocNetto, long zasieg, int iloscMiejsc,
                              int iloscPakietowZasilajacych, int poziomNaladowania,
                              String miasto, boolean oznaczenieKursu) {
        super(idAutobusu, przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc);

        this.iloscPakietowZasilajacych = iloscPakietowZasilajacych;
        this.poziomNaladowania = poziomNaladowania;

        zasiegKursu = new AutobusMiejski(miasto, oznaczenieKursu);

        dodajDoEkstensji();
    }

    public AutobusElektryczny(int idAutobusu, long przebieg, int rokProdukcji, String model, long mocNetto, long zasieg, int iloscMiejsc,
                              int iloscPakietowZasilajacych, int poziomNaladowania,
                              long maxOdlegloscOdZajezdni, boolean czyPozaKraj, String... listaMiast) {
        super(idAutobusu, przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc);

        this.iloscPakietowZasilajacych = iloscPakietowZasilajacych;
        this.poziomNaladowania = poziomNaladowania;

        zasiegKursu = new AutobusMiedzymiastowy(maxOdlegloscOdZajezdni, czyPozaKraj, listaMiast);

        dodajDoEkstensji();
    }

    public void wymianaAkumulatora() {

    }

    private void dodajDoEkstensji() {
        if (!areErrors())
            autobusEkstensja.add(this);
    }

    public boolean areErrors() {
        return this.poziomNaladowania < 0 || this.poziomNaladowania > 100 || this.zasieg < 0 || this.iloscPakietowZasilajacych <= 0 || this.iloscMiejsc < 0 || mocNetto < 0 || this.przebieg < 0;
    }
}
