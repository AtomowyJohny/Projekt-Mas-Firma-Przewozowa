package AtomowyProjekt.Autobusy.ZasiegKursu;

public class AutobusMiejski extends ZasiegKursu {
    public String miasto;
    public boolean oznaczenieKursu;

    public AutobusMiejski(String miasto, boolean oznaczenieKursu) {
        this.miasto = miasto;
        this.oznaczenieKursu = oznaczenieKursu;
    }

    public boolean checkErrors() {
        return false;
    }

    public void zmienOznaczenieKursu() {
        oznaczenieKursu = !oznaczenieKursu;
    }

}
