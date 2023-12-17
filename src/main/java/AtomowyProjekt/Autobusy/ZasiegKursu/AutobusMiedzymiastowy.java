package AtomowyProjekt.Autobusy.ZasiegKursu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutobusMiedzymiastowy extends ZasiegKursu {
    public long maxOdlegloscOdZajezdni;
    public boolean czyPozaKraj;
    public List<String> listaMiast = new ArrayList<>();

    public AutobusMiedzymiastowy(long maxOdlegloscOdZajezdni, boolean czyPozaKraj, String... miasta) {
        this.maxOdlegloscOdZajezdni = maxOdlegloscOdZajezdni;
        this.czyPozaKraj = czyPozaKraj;
        listaMiast.addAll(Arrays.asList(miasta));
    }

    public void zmienMaksymalnaOdlegloscOdZajezdni(int maxOdlegloscOdZajezdni) {
        this.maxOdlegloscOdZajezdni = maxOdlegloscOdZajezdni;
    }
}
