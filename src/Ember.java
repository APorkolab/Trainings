//
//Az Ember osztályunk szintén rendelkezik egy névvel (String nev), szükséges eltárolnunk a testtömegét (int kilogramm), és a vérében lévő alkoholmennyiséget (double alkoholGramm).
//Az Ember képes:
//
//    Meginni egy alkoholtartalmú italt (void megiszik(Ital ital)), melynek hatására a vérében lévő alkoholmennyiség az italban található alkoholmennyiséggel megnő.
//    Pihenni valamicskét (void pihen(double ora)), mely alatt a mája 9 gramm/óra sebességgel elkezdi bontani a vérében lévő alkoholt.
//    Nyilatkozni arról, hogy mennyi a véralkoholszintje ezrelékben (double veralkoholEzrelek()), amit az alkoholGramm és a kilogramm hányadosaként ad meg.
//    Nyilatkozni arról, hogy mennyi idő kell még neki ahhoz, hogy újra volán mögé ülhessen (double getJozanIdo()), mely meghatározza az alkoholGramm alapján, hogy mennyi pihenés után lesz a vérében az alkoholszint újra 0.

public class Ember {

    String nev;
    int kilogramm;
    double alkoholGramm;

    public void megiszik(Ital ital) {
        double verAlkohol = 0.0;
        double italAlkohol = ital.getAlkoholGramm();
        verAlkohol = verAlkohol + italAlkohol;
    }

    public void pihen(double ora) {
        alkoholGramm = this.veralkoholEzrelek() - (ora * 9);
    }

    public double veralkoholEzrelek() {
        double verAlkohol = alkoholGramm / kilogramm;
        return verAlkohol;
    }

    public double getJozanIdo() {
        double ora = 0;
        while (this.alkoholGramm==0){
            this.pihen(ora);
            ora++;
        }
        return Math.ceil(ora);
    }
}
