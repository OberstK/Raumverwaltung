package verwaltung;

import raeume.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MeinScanner {
    private String input;

//////////////////////HELPER////////////////////////////////

    public int sucheRaum(String suchBegriff, ArrayList<Raum> raumListe) {
        Collections.sort(raumListe);

        int index = -1;

        for (int i = 0; i < raumListe.size(); i++) {
            if (raumListe.get(i).getName().equalsIgnoreCase(suchBegriff)) {
                index = i;
            }
        }

        return index;
    }


    public boolean raumSchonVorhanden(String name, ArrayList<Raum> raumListe) {
        if (sucheRaum(name, raumListe) == -1) {
            return false;
        } else {
            return raumListe.get(sucheRaum(name, raumListe)).getName().equalsIgnoreCase(name);
        }
    }


    public void zeigeRaeumeAn(String input, ArrayList<Raum> raumListe) {

        Analyser ana = new Analyser();

        String[] data = ana.splitArguments(input);

        int sort = ana.analyseSort(data[0]);

        if (sort == 0) {
            Collections.sort(raumListe);
        } else if (sort == 1) {
            Collections.sort(raumListe, Collections.reverseOrder());
        }

        for (Object o : raumListe) {
            if (o instanceof Konferenzraum) {
                Konferenzraum showKRaum = (Konferenzraum) o;
                System.out.println("Name: " + showKRaum.getName() + " | Groesse: " + showKRaum.getGroesse() + "qm | Status: " + showKRaum.getTextStatus() + " -> ist ein " + showKRaum.getTyp());
            } else if (o instanceof Arbeitsraum) {
                Arbeitsraum showARaum = (Arbeitsraum) o;
                System.out.println("Name: " + showARaum.getName() + " | Groesse: " + showARaum.getGroesse() + "qm | Beamer: " + showARaum.getTextBeamer() + " | Sitze: " + showARaum.getSitze() + " -> ist ein " + showARaum.getTyp());
            } else if (o instanceof Kueche) {
                Kueche showKueche = (Kueche) o;
                System.out.println("Name: " + showKueche.getName() + " | Groesse: " + showKueche.getGroesse() + "qm | Kaffeemaschine: " + showKueche.getTextKaffee() + " | Gedecke: " + showKueche.getGedecke() + " -> ist eine " + showKueche.getTyp());
            } else if (o instanceof Toilette) {
                Toilette showToi = (Toilette) o;
                System.out.println("Name: " + showToi.getName() + " | Groesse: " + showToi.getGroesse() + "qm | Reinigungs-Status: " + showToi.getSauber() + " | Geschlecht: " + showToi.getTextGeschlecht() + " -> ist eine " + showToi.getTyp());
            } else if (o == null) {
                System.out.println("Keine Raeume vorhanden");
            } else {
                System.out.println("Keine Raeume vorhanden");
            }
        }

        if (raumListe.isEmpty()) {
            System.out.println("Noch keine Raeume vorhanden");
        }


    }


    public String getNameToEditOrDelete(String input) {

        Analyser ana = new Analyser();

        String[] dataArray = ana.splitArguments(input);

        String neuName = dataArray[0].trim();

        return neuName;
    }


    ///////////////////////////BEARBEITEN///////////////////////////////////

    public Konferenzraum bearbeiteKonferenzRaum() {

        MeinScanner myscan = new MeinScanner();
        Analyser ana = new Analyser();
        Konferenzraum editRaum = new Konferenzraum();

        System.out.println("Bitte gib die Daten fuer den Konferenzraum nach diesem Schema an:");
        System.out.println("Daten: Name, Groesse, Status");

        String data = myscan.scanInputEditData();

        String[] dataArray = ana.splitArguments(data);

        String neuName = dataArray[0].trim();
        int groesse = ana.analyseInt(dataArray[1]);
        boolean status = ana.analyseStatus(dataArray[2]);

        editRaum.setName(neuName);
        editRaum.setGroesse(groesse);
        editRaum.setStatus(status);

        return editRaum;
    }

    public Arbeitsraum bearbeiteArbeitsRaum() {

        MeinScanner myscan = new MeinScanner();
        Analyser ana = new Analyser();
        Arbeitsraum editRaum = new Arbeitsraum();

        System.out.println("Bitte gib die Daten fuer den Arbeitsraum nach diesem Schema an:");
        System.out.println("Daten: Name, Groesse, Beamer-Status, Sitze");

        String data = myscan.scanInputEditData();

        String[] dataArray = ana.splitArguments(data);

        String neuName = dataArray[0].trim();
        int groesse = ana.analyseInt(dataArray[1]);
        boolean beamer = ana.analyseBeamer(dataArray[2]);
        int sitze = ana.analyseInt(dataArray[3]);

        editRaum.setName(neuName);
        editRaum.setGroesse(groesse);
        editRaum.setBeamer(beamer);
        editRaum.setSitze(sitze);

        return editRaum;

    }

    public Kueche bearbeiteKueche() {
        MeinScanner myscan = new MeinScanner();
        Analyser ana = new Analyser();
        Kueche editRaum = new Kueche();

        System.out.println("Bitte gib die Daten fuer die Kueche nach diesem Schema an:");
        System.out.println("Daten: Name, Groesse, Kaffeemaschine, Gedecke");

        String data = myscan.scanInputEditData();

        String[] dataArray = ana.splitArguments(data);

        String neuName = dataArray[0].trim();
        int groesse = ana.analyseInt(dataArray[1]);
        boolean kaffee = ana.analyseKaffee(dataArray[2]);
        int gedecke = ana.analyseInt(dataArray[3]);

        editRaum.setName(neuName);
        editRaum.setGroesse(groesse);
        editRaum.setKaffee(kaffee);
        editRaum.setGedecke(gedecke);

        return editRaum;
    }

    public Toilette bearbeiteToilette() {

        MeinScanner myscan = new MeinScanner();
        Analyser ana = new Analyser();
        Toilette editRaum = new Toilette();

        System.out.println("Bitte gib die Daten fuer die Toilette nach diesem Schema an:");
        System.out.println("Daten: Name, Groesse, Sauberkeit, Geschlecht");

        String data = myscan.scanInputEditData();

        String[] dataArray = ana.splitArguments(data);

        String neuName = dataArray[0].trim();
        int groesse = ana.analyseInt(dataArray[1]);
        String sauber = dataArray[2].trim();
        boolean geschlecht = ana.analyseGeschlecht(dataArray[3]);

        editRaum.setName(neuName);
        editRaum.setGroesse(groesse);
        editRaum.setSauber(sauber);
        editRaum.setGeschlecht(geschlecht);

        return editRaum;
    }


    //////////////////////ANLEGEN/////////////////////////////////

    public Raum legeKonferenzRaumAn(String input) {

        try {

            Analyser ana = new Analyser();
            String[] data = ana.splitArguments(input);

            String name = data[0].trim();
            int groesse = ana.analyseInt(data[1]);
            boolean status = ana.analyseStatus(data[2]);

            return new Konferenzraum(name, groesse, status);


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bitte halte dich an das vorgegeben Befehlsschema!");

            return null;
        }

    }

    public Raum legeToiletteAn(String input) {

        try {
            Analyser ana = new Analyser();

            String[] data = ana.splitArguments(input);

            String name = data[0].trim();
            int groesse = ana.analyseInt(data[1]);
            String sauber = data[2].trim();
            boolean geschlecht = ana.analyseGeschlecht(data[3]);

            return new Toilette(name, groesse, sauber, geschlecht);


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bitte halte dich an das vorgegeben Befehlsschema!");

            return null;
        }
    }

    public Raum legeArbeitsRaumAn(String input) {

        try {

            Analyser ana = new Analyser();
            String[] data = ana.splitArguments(input);

            String name = data[0].trim();
            int groesse = ana.analyseInt(data[1]);
            boolean beamer = ana.analyseBeamer(data[2]);
            int sitze = ana.analyseInt(data[3]);

            return new Arbeitsraum(name, groesse, beamer, sitze);


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bitte halte dich an das vorgegeben Befehlsschema!");


            return null;
        }
    }

    public Raum legeKuecheAn(String input) {

        try {
            Analyser ana = new Analyser();

            String[] data = ana.splitArguments(input);

            String name = data[0].trim();
            int groesse = ana.analyseInt(data[1]);
            boolean kaffee = ana.analyseKaffee(data[2]);
            int gedecke = ana.analyseInt(data[3]);


            return new Kueche(name, groesse, kaffee, gedecke);


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bitte halte dich an das vorgegeben Befehlsschema!");


            return null;
        }

    }


    public ArrayList<Object> scanInput() {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        scanner.close();

        if (input.contains("Neuer K-Raum")) {

            ArrayList<Object> liste = new ArrayList<Object>();

            liste.add("Add");
            liste.add(legeKonferenzRaumAn(input));

            return liste;

        } else if (input.contains("Neuer A-Raum")) {

            ArrayList<Object> liste = new ArrayList<Object>();

            liste.add("Add");
            liste.add(legeArbeitsRaumAn(input));

            return liste;

        } else if (input.contains("Neue Kueche")) {

            ArrayList<Object> liste = new ArrayList<Object>();

            liste.add("Add");
            liste.add(legeKuecheAn(input));

            return liste;

        } else if (input.contains("Neue Toilette")) {

            ArrayList<Object> liste = new ArrayList<Object>();

            liste.add("Add");
            liste.add(legeToiletteAn(input));

            return liste;

        } else if (input.contains("Zeige Raeume")) {

            ArrayList<Object> liste = new ArrayList<Object>();

            liste.add("Show");

            return liste;

        } else if (input.contains("Bearbeite Raum")) {

            ArrayList<Object> liste = new ArrayList<Object>();

            liste.add("Edit");
            liste.add(getNameToEditOrDelete(input));

            return liste;

        } else if (input.contains("Loesche Raum")) {

            ArrayList<Object> liste = new ArrayList<Object>();

            liste.add("Del");
            liste.add(getNameToEditOrDelete(input));

            return liste;

        } else if (input.equals("exit")) {

            ArrayList<Object> liste = new ArrayList<Object>();
            liste.add("exit");

            return liste;

        } else {

            return null;

        }

    }

    public String scanInputEditData() {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        scanner.close();

        return input;
    }

    public MeinScanner() {

    }
}
