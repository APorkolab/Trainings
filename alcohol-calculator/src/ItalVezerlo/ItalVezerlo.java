//Készítsünk alkoholkalkulátor programot!
//
//Ehhez két osztályra lesz szükségünk: az Ital-ra és az Ember-re.
//
//Az Ital osztály egy szeszes ital adagot fog reprezentálni, ennek megfelelően három adattagja lesz: neve (String nev), töménysége (double szazalek), és térfogata (int ml). Az osztály képes meghatározni a benne található alkohol mennyiségét grammban a double getAlkoholGramm() metódus segítségével. Az ehhez szükséges képlet:0.8*ml*szazalek/100.0
//
//Az Ember osztályunk szintén rendelkezik egy névvel (String nev), szükséges eltárolnunk a testtömegét (int kilogramm), és a vérében lévő alkoholmennyiséget (double alkoholGramm).
//Az Ember képes:
//
//    Meginni egy alkoholtartalmú italt (void megiszik(Ital ital)), melynek hatására a vérében lévő alkoholmennyiség az italban található alkoholmennyiséggel megnő.
//    Pihenni valamicskét (void pihen(double ora)), mely alatt a mája 9 gramm/óra sebességgel elkezdi bontani a vérében lévő alkoholt.
//    Nyilatkozni arról, hogy mennyi a véralkoholszintje ezrelékben (double veralkoholEzrelek()), amit az alkoholGramm és a kilogramm hányadosaként ad meg.
//    Nyilatkozni arról, hogy mennyi idő kell még neki ahhoz, hogy újra volán mögé ülhessen (double getJozanIdo()), mely meghatározza az alkoholGramm alapján, hogy mennyi pihenés után lesz a vérében az alkoholszint újra 0.
//
//Készítsünk a programhoz egy szöveges keretprogramot! Ez legyen az ItalVezerlo osztály, melyben a szokásos main() függvényünk található. Ebben először kérjük be emberünk adatait, majd egy visszatérő menüből kiválaszthatjuk, hogy iszunk vagy pihenünk; ha iszunk, mit iszunk (Ital összes adatát bekérjük, majd megitatjuk emberünkkel), ha pihenünk, mennyit pihenünk.
//Minden művelet után (ideértve a kilépést is!) írjuk ki az ember véralkoholszintjét grammban és ezrelékben!
//Példa az objektumok használatára:
//
//Ember feri = new Ember();
//feri.nev = "Feri";
//feri.kilogramm = 98;
//Ital palinka = new Ital();
//palinka.ml = 50;
//palinka.szazalek = 50;
//System.out.println(palinka.getAlkoholGramm());
//feri.megiszik(palinka);
//System.out.println(feri.veralkoholEzrelek());
//System.out.println(feri.getJozanIdo());
//feri.pihen(9.3);
//System.out.println(feri.veralkoholEzrelek());
//System.out.println(feri.getJozanIdo());
//
//Ennek eredménye:
//
//20.0
//0.20408163265306123
//2.2222222222222223
//0.0
//0.0
//
//Példa a program futtatására:
//
//Hogy hívnak? Karoly
//Hány kiló vagy? 88
//Mit csinálsz?
//1 - iszol
//2 - pihensz
//3 - kilépsz
//1
//Mit iszol? palinka
//Hány százalékos alkoholtartalmú? 50
//Mennyit iszol belőle? 50
//Karoly véralkoholszintje: 20,00 gramm, azaz 0,23 ezrelék.
//Mit csinálsz?
//1 - iszol
//2 - pihensz
//3 - kilépsz
//2
//Mennyit pihensz? 1
//Karoly véralkoholszintje: 11,00 gramm, azaz 0,13 ezrelék.
//Mit csinálsz?
//1 - iszol
//2 - pihensz
//3 - kilépsz
//3
//Karoly véralkoholszintje: 11,00 gramm, azaz 0,13 ezrelék.
//
//A dőlt betűvel szedett szövegek a felhasználó által bevitt adatok.
//
//Megjegyzés. Ahogyan a 11. fejezetben is, itt is és mindenhol máshol is csak egyetlen Scanner objektumot hozz létre. Ha kell más függvényben/metódusban, add át a referenciáját.
package ItalVezerlo;

import java.util.Scanner;

public class ItalVezerlo {

    public static void main(String[] args) {
        int valasztas;
        Scanner sc = new Scanner(System.in);
        Ember ember = new Ember();
        System.out.print("Hogy hívnak? ");
        ember.nev = sc.nextLine();
        System.out.print("Hány kiló vagy? ");
        int kilogramm = sc.nextInt();
        ember.kilogramm = kilogramm;
        do {
            System.out.println("Mit csinálsz?");
            System.out.println("1 - iszol");
            System.out.println("2 - pihensz");
            System.out.println("3 - kilépsz");
            valasztas = sc.nextShort();
            switch (valasztas) {
                case 1:
                    Ital ital = new Ital();
                    System.out.print("Mit iszol? ");
                    ital.nev = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Hány százalékos alkoholtartalmú? ");
                    ital.szazalek = sc.nextDouble();
                    System.out.print("Mennyit iszol belőle? ");
                    sc.nextLine();
                    ital.ml = sc.nextInt();
                    ember.megiszik(ital);
                    System.out.printf("%s véralkoholszintje: %.2f gramm, azaz %.2f ezrelék.%n", ember.nev, ember.alkoholGramm, ember.veralkoholEzrelek());
                    break;
                case 2:
                    System.out.print("Mennyit pihensz? ");
                    double pihenoIdo = sc.nextDouble();
                    ember.pihen(pihenoIdo);
                    System.out.printf("%s véralkoholszintje: %.2f gramm, azaz %.2f ezrelék.%n", ember.nev, ember.alkoholGramm, ember.veralkoholEzrelek());
                    break;
                case 3:
                    System.out.printf("%s véralkoholszintje: %.2f gramm, azaz %.2f ezrelék.%n", ember.nev, ember.alkoholGramm, ember.veralkoholEzrelek());
                    return;
                default:
                    throw new AssertionError();

            }
        } while (valasztas != 3);
    }
}

//        Ember feri = new Ember();
//        feri.nev = "Feri";
//        feri.kilogramm = 98;
//        Ital palinka = new Ital();
//        palinka.ml = 50;
//        palinka.szazalek = 50;
//        System.out.println(palinka.getAlkoholGramm());
//        feri.megiszik(palinka);
//        System.out.println(feri.veralkoholEzrelek());
//        System.out.println(feri.getJozanIdo());
//        feri.pihen(9.3);
//        System.out.println(feri.veralkoholEzrelek());
//        System.out.println(feri.getJozanIdo());
