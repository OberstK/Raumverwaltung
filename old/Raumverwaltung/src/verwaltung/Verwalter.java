package verwaltung;

import raeume.*;

import java.io.File;
import java.util.ArrayList;

public class Verwalter {

    public static ArrayList<Raum> raumListe = new ArrayList<Raum>();

    public void saveList() {
        XMLSaver save = new XMLSaver();
        save.saveToXMl(raumListe);
    }


    public void loadList() {
        XMLSaver load = new XMLSaver();
        raumListe.addAll(load.loadFromXL());
    }


    public void legeAn(Raum raum){
        MeinScanner myscan = new MeinScanner();

        String name = raum.getName();

        if(myscan.raumSchonVorhanden(name, raumListe)==false){

            if(raum instanceof Konferenzraum){
                raumListe.add(raum);
                System.out.println("Konferenzraum angelegt!");
            }else if(raum instanceof Arbeitsraum){
                raumListe.add(raum);
                System.out.println("Arbeitsraum angelegt!");
            }else if(raum instanceof Toilette){
                raumListe.add(raum);
                System.out.println("Toilette angelegt!");
            }else if(raum instanceof Kueche){
                raumListe.add(raum);
                System.out.println("Kueche angelegt!");
            }else{
                System.out.println("Kein gueltiger Raum angelegt");
            }

        }else{
            System.out.println("Ein Raum mit diesem Namen ist bereits vorhanden. Raum wurde nicht angelegt!");
        }

    }

    public void bearbeite(int index){
        MeinScanner myscan = new MeinScanner();
        Raum raum = raumListe.get(index);

        if(raum instanceof Konferenzraum){

            Konferenzraum edited = myscan.bearbeiteKonferenzRaum();

            if(myscan.sucheRaum(edited.getName(), raumListe)==-1){
                raumListe.set(index, edited);
                System.out.println("Konferenzraum wurde geaendert!");
            }else{
                raumListe.set(index, raum);
                System.out.println("Einen Raum mit diesem Namen gibt es bereits");
            }

        }else if(raum instanceof Arbeitsraum){

            Arbeitsraum edited = myscan.bearbeiteArbeitsRaum();

            if(myscan.sucheRaum(edited.getName(), raumListe)==-1){
                raumListe.set(index, edited);
                System.out.println("Arbeitsraum wurde geaendert!");
            }else{
                raumListe.set(index, raum);
                System.out.println("Einen Raum mit diesem Namen gibt es bereits");
            }

        }else if(raum instanceof Toilette){

            Toilette edited = myscan.bearbeiteToilette();

            if(myscan.sucheRaum(edited.getName(), raumListe)==-1){
                raumListe.set(index, edited);
                System.out.println("Toilette wurde geaendert!");
            }else{
                raumListe.set(index, raum);
                System.out.println("Einen Raum mit diesem Namen gibt es bereits");
            }

        }else if(raum instanceof Kueche){

            Kueche edited = myscan.bearbeiteKueche();

            if(myscan.sucheRaum(edited.getName(), raumListe)==-1){
                raumListe.set(index, edited);
                System.out.println("Kueche wurde geaendert!");
            }else{
                raumListe.set(index, raum);
                System.out.println("Einen Raum mit diesem Namen gibt es bereits");
            }

        }else{

            System.out.println("Kein gueltiger Raum angelegt");

        }
    }

    public void loesche(int index){
        if(index!=-1){

            raumListe.remove(index);

            System.out.println("Raum wurde geloescht!");

        }else{

            System.out.println("Ein Raum mit diesem Namen existiert nicht!");

        }

    }

    public void listenUser(){
        MeinScanner myscan = new MeinScanner();

        ArrayList<Object> liste = myscan.scanInput();

        if(liste == null){
            System.out.println("Befehl nicht verstanden!");

            this.listenUser();

        }else if(liste.get(0)=="Add" && liste.get(1)!=null){

            this.legeAn((Raum) liste.get(1));

            this.listenUser();

        }else if(liste.get(0)=="Show"){

            myscan.zeigeRaeumeAn("0", raumListe);

            this.listenUser();

        }else if(liste.get(0)=="Del"){

            int indexGefunden = myscan.sucheRaum((String) liste.get(1), raumListe);
            loesche(indexGefunden);

            this.listenUser();

        }else if(liste.get(0)=="Edit"&& liste.get(1)!=null){
            try {
                int indexGefunden = myscan.sucheRaum((String) liste.get(1), raumListe);
                bearbeite(indexGefunden);
                this.listenUser();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Halte dich an das gegebene Befehlsschema!");
                this.listenUser();
            }


        }else if(liste.get(0)=="exit"){
            this.saveList();
            System.out.println("Bis bald!");

        }else{
            System.out.println("Fehler! Bitte erneut versuchen!");

            this.listenUser();
        }

    }




    public Verwalter() {

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
       

// Begruessungstext und Befehle//

        System.out
                .println("/////Willkommen bei ihren Raumverwaltungstool!/////");
        System.out.println("\n");
        System.out
                .println("Um es zu verwenden stehen ihnen folgende Befehle zur Verfuegung:");
        System.out.println("\n");
        System.out.println("- Neuer K-Raum: Name, Groesse, Status -> fuer Konferenzraeume");
        System.out.println("- Neuer A-Raum: Name, Groesse, Beamer-Status (v oder nv), Sitze -> fuer Arbeitsraeume");
        System.out.println("- Neue Toilette: Name, Groesse, Sauberkeitsstatus, Geschlecht");
        System.out.println("- Neue Kueche: Name, Grosse, Kaffee-Maschine(v oder nv), Gedecke");
        System.out.println("- Zeige Raeume");
        System.out.println("- Loesche Raum: Name");
        System.out.println("- Bearbeite Raum: Name des zu bearbeitenden Raums");
        System.out.println("- exit");
        System.out.println("- WICHTIG: Das Programm immer mit dem Befehl exit beenden! Datenverlust ist sonst die Folge!");
        System.out.println("\n");

        // Run//

        Verwalter verw = new Verwalter();
        if (new File("Datenbank.xml").exists()) {
            verw.loadList();
        } else {
            verw.saveList();
        }





        try {
            MeinScanner myscan = new MeinScanner();

            if (args[0].equalsIgnoreCase("asc")) {

                System.out.println("Liste der vorhandenen Raeume(aufsteigend):");
                System.out.println("\n");

                myscan.zeigeRaeumeAn("0", raumListe);
            } else if (args[0].equalsIgnoreCase("desc")) {

                System.out.println("Liste der vorhandenen Raeume (absteigend):");
                System.out.println("\n");

                myscan.zeigeRaeumeAn("1", raumListe);
            } else {

                myscan.zeigeRaeumeAn("2", raumListe);
            }


            System.out.println("\n");



        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Bitte geben sie einen Startparameter an, der die Sortierung der Raeume angibt. asc oder desc stehen zur Verfuegung.");
            System.out.println("\n");
        }



        verw.listenUser();
    }

}
