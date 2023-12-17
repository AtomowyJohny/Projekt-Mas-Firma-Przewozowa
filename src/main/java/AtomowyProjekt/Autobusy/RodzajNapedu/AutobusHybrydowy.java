package AtomowyProjekt.Autobusy.RodzajNapedu;

import AtomowyProjekt.Autobusy.Autobus;
import AtomowyProjekt.Autobusy.ZasiegKursu.AutobusMiedzymiastowy;
import AtomowyProjekt.Autobusy.ZasiegKursu.AutobusMiejski;
import AtomowyProjekt.Autobusy.ZasiegKursu.ZasiegKursu;

public class AutobusHybrydowy extends Autobus {
    public AutobusElektryczny autobusElektryczny;
    public AutobusSilnikowy autobusSilnikowy;

    enum TypNapeduHybrydowego { rownolegly, szeregowy }
    public TypNapeduHybrydowego typNapeduHybrydowego;
    public boolean ladowaniePlugin;

    ZasiegKursu zasiegKursu;

    public AutobusHybrydowy(int idAutobusu, long przebieg, int rokProdukcji, String model, long mocNetto, long zasieg, int iloscMiejsc,
                            String typNapeduHybrydowego, boolean ladowaniePlugin,
                            int iloscPakietowZasilajacych, int poziomNaladowania,
                            int iloscKoni, int spalanie, int pojemnoscZbiornika, String typPaliwa, int iloscPaliwa,
                            String miasto, boolean oznaczenieKursu) {
        super(idAutobusu, przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc);
//        this.autobusElektryczny = new AutobusElektryczny(przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc,
//                iloscPakietowZasilajacych, poziomNaladowania);
//        this.autobusSilnikowy = new AutobusSilnikowy(przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc,
//                iloscKoni, spalanie, pojemnoscZbiornika, typPaliwa, iloscPaliwa);
        this.zasiegKursu = new AutobusMiejski(miasto, oznaczenieKursu);
        this.typNapeduHybrydowego = typNapeduHybrydowego.equalsIgnoreCase(TypNapeduHybrydowego.rownolegly.name())? TypNapeduHybrydowego.rownolegly :
                typNapeduHybrydowego.equalsIgnoreCase(TypNapeduHybrydowego.szeregowy.name())? TypNapeduHybrydowego.szeregowy : null;
        this.ladowaniePlugin = ladowaniePlugin;
    }

    public AutobusHybrydowy(int idAutobusu, long przebieg, int rokProdukcji, String model, long mocNetto, long zasieg, int iloscMiejsc,
                            String typNapeduHybrydowego, boolean ladowaniePlugin,
                            int iloscPakietowZasilajacych, int poziomNaladowania,
                            int iloscKoni, int spalanie, int pojemnoscZbiornika, String typPaliwa, int iloscPaliwa,
                            long maxOdlegloscOdZajezdni, boolean czyPozaKraj, String... listaMiast) {
        super(idAutobusu, przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc);
//        this.autobusElektryczny = new AutobusElektryczny(przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc,
//                iloscPakietowZasilajacych, poziomNaladowania);
//        this.autobusSilnikowy = new AutobusSilnikowy(przebieg, rokProdukcji, model, mocNetto, zasieg, iloscMiejsc,
//                iloscKoni, spalanie, pojemnoscZbiornika, typPaliwa, iloscPaliwa);
        this.zasiegKursu = new AutobusMiedzymiastowy(maxOdlegloscOdZajezdni, czyPozaKraj, listaMiast);
        this.typNapeduHybrydowego = typNapeduHybrydowego.equalsIgnoreCase(TypNapeduHybrydowego.rownolegly.name()) ? TypNapeduHybrydowego.rownolegly :
                typNapeduHybrydowego.equalsIgnoreCase(TypNapeduHybrydowego.szeregowy.name()) ? TypNapeduHybrydowego.szeregowy : null;
        this.ladowaniePlugin = ladowaniePlugin;
    }
}
