
public class Ital {

    String nev;
    double szazalek;
    int ml;

    public double getAlkoholGramm() {
        double ItalAlkohol = 0.8 * ml * szazalek / 100.0;
        return ItalAlkohol;
    }
}
