package AtomowyProjekt.Autobusy.RodzajNapedu;

public class Akumulator {
    private int idAkumulatoru;

    public int pojemnosc, znamionowaIloscCykli, iloscCykliRozladowania, poziomNaladowania;

    public Akumulator(int pojemnosc, int znamionowaIloscCykli, int iloscCykliRozladowania, int poziomNaladowania) {
        this.pojemnosc = pojemnosc;
        this.znamionowaIloscCykli = znamionowaIloscCykli;
        this.iloscCykliRozladowania = iloscCykliRozladowania;
        this.poziomNaladowania = poziomNaladowania;

        if (pojemnosc > 0 || znamionowaIloscCykli > 0 || iloscCykliRozladowania > 0 ||
                (poziomNaladowania > 0 && poziomNaladowania < 100))
            System.out.println("ekstensja");
    }

    public void sprawdzZuzycieAkumulatora() {

    }

    public void podlaczLadowarke(String trybPracy) {
        if (!trybPracy.equalsIgnoreCase("szybkieladowanie")
                && !trybPracy.equalsIgnoreCase("przechowywanie")
                && !trybPracy.equalsIgnoreCase("rozladowywanie"))
            return;
        System.out.println("ok");
    }

}
