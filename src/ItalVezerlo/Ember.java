package ItalVezerlo;

public class Ember {

    String nev;
    int kilogramm;
    double alkoholGramm;

    public void megiszik(Ital ital) {
        alkoholGramm = alkoholGramm + ital.getAlkoholGramm();
    }

    public void pihen(double ora) {
        alkoholGramm = this.alkoholGramm - (ora * 9);
        if (alkoholGramm <= 0) {
            alkoholGramm = 0;
        }
    }

    public double veralkoholEzrelek() {
        double verAlkohol = this.alkoholGramm / kilogramm;
        if (verAlkohol <= 0) {
            verAlkohol = 0;
        }
        return verAlkohol;
    }

    public double getJozanIdo() {
        double mennyiIdo = this.alkoholGramm / 9.;
        return mennyiIdo;
    }
}
