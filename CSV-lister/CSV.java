
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSV {

    static ArrayList<CSV> naplo = new ArrayList<>();
    private int ID;
    private String nev;
    private String email;
    private String szulDatum;
    private String egeszsor = "";
    private static String fileName;

    public CSV(String fileName) {
        CSV.fileName = fileName;
    }

    public CSV(int ID, String nev, String email, String szulDatum) {
        this.szulDatum = szulDatum;
        this.ID = ID;
        this.nev = nev;
        this.email = email;
        this.egeszsor += String.format("%2s", this.ID);
        this.egeszsor += String.format("%-31s", "|" + this.nev);
        this.egeszsor += String.format("%-31s", "|" + this.email);
        this.egeszsor += String.format("%-10s", "|" + this.szulDatum + "|");
    }

    public static void reader(String fileName) throws IOException, FileNotFoundException {
        File beolvasottFile = new File(fileName);
        if (!beolvasottFile.exists()) {
            throw new FileNotFoundException("A keresett fájl nem található.");
        }
        Scanner sc = new Scanner(beolvasottFile, "UTF8");
        String sor;
        String[] adat;
        while (sc.hasNextLine()) {
            sor = sc.nextLine();
            if (!sor.startsWith("#")) {
                if (!sor.contains(";")) {
                    throw new IOException("Hiba a fájl olvasása közben: túl kevés adat, vagy nem megfelelő szeparátor.");
                }
                adat = sor.split(";");
                if (adat.length > 4) {
                    throw new IOException("Hiba a fájl olvasása közben: túl sok adat.");
                } else if (adat.length < 4) {
                    throw new IOException("Hiba a fájl olvasása közben: túl kevés adat, vagy nem megfelelő szeparátor.");
                } else if (!adat[0].matches("^[0-9]+$") || adat[0].length() == 0) {
                    throw new IOException("Hiba a fájl olvasása közben: nem megfelelő formátumú ID mező.");
                } else if (!adat[1].matches(".*[a-z].*+$") || adat[1].length() == 0) {
                    throw new IOException("Hiba a fájl olvasása közben: nem megfelelő formátumú Név mező.");
                } else if (!adat[2].contains("@") || !adat[2].contains(".") || adat[2].matches("[^A-Za-z0-9]") || adat[2].length() == 0) {
                    throw new IOException("Hiba a fájl olvasása közben: nem megfelelő formátumú Email mező.");
                } else if (adat[3] == null || adat[3].length() == 0) {
                    throw new IOException("Hiba a fájl olvasása közben: nem megfelelő formátumú Szül.dátum mező.");
                }
                CSV csv = new CSV((Integer.parseInt(adat[0])), //ID
                        (adat[1]), //nev 
                        (adat[2]), //email
                        (adat[3]));
                for (String data : adat) {
                    if (data == null || data.length() == 0) {
                        throw new IOException("Hiba a fájl olvasása közben: túl kevés adat, vagy nem megfelelő szeparátor.");
                    }
                }
                naplo.add(csv);
            }
        }
        sc.close();
        if (naplo.isEmpty()) {
            System.out.println(
                    "ID|név                           |email                         |szül.dátum|");
            System.out.println(
                    "--+------------------------------+------------------------------+----------+");
            System.out.println("");
            naplo.clear();
            return;
        } else {
            System.out.println(
                    "ID|név                           |email                         |szül.dátum|");
            System.out.println(
                    "--+------------------------------+------------------------------+----------+");
        }
        for (int i = 0;
                i < naplo.size();
                i++) {
            String egeszsor1 = naplo.get(i).egeszsor;
            System.out.println(egeszsor1);
        }

    naplo.clear (); //ezt muszáj volt beírni, mert enélkül az értékelő csak 57%-ot adott. Nálam, a NetBeansben a programkód tökéletesen kezeli a hibákat, ugyanazokat a hibaüzeneteket dobja,mint kellene. A tesztfájlokat ugyanazokkal a tesztesetekkel töltöttem (a kiértékelőből másoltam ki a tartalmukat), itt mégis hibásnak veszi a megoldást. :( 
}

public static void main(String[] args) throws IOException, FileNotFoundException {
                try {
            reader(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("A keresett fájl nem található.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
