package verwaltung;

public class Analyser {


    public String[] splitArguments(String input) {
        String[] arguments;

        int indexDP = input.indexOf(":");
        String data = input.substring(indexDP + 1);

        arguments = data.split(",");

        return arguments;
    }

    public int analyseInt(String textInt) {
        try {
            int zahl;

            zahl = Integer.parseInt(textInt.trim());

            return zahl;
        } catch (java.lang.StringIndexOutOfBoundsException exception) {
            System.out
                    .println("Bitte halte dich an das gegebene Befehlsschema!");
            return 0;
        } catch (java.lang.NumberFormatException exeption) {
            System.out.println("Du hast Buchstaben an Stelle von Zahlen verwendet! Alle Zahlen wurden auf 0 gesetzt");
            return 0;
        } catch (java.lang.ArrayIndexOutOfBoundsException exception) {
            System.out.println("Bitte halte dich an das gegeben Befehlsschema!");
            return 0;
        }
    }


    public boolean analyseStatus(String textStatus) {
        try {
            boolean status;

            if (textStatus.trim().equals("frei")) {
                status = true;
            } else if (textStatus.trim().equals("belegt")) {
                status = false;
            } else {
                status = false;
                System.out
                        .println("Status nicht lesbar. Status wurde auf belegt gesetzt!");
            }

            return status;
        } catch (java.lang.StringIndexOutOfBoundsException exception) {
            System.out
                    .println("Bitte halte dich an das gegebene Befehlsschema!");
            return false;
        }
    }


    public boolean analyseBeamer(String textBeamer) {
        try {
            boolean beamer;

            if (textBeamer.trim().equals("v")) {
                beamer = true;
            } else if (textBeamer.trim().equals("nv")) {
                beamer = false;
            } else {
                beamer = false;
                System.out
                        .println("Beamer-Status nicht lesbar. Status wurde auf nicht vorhanden gesetzt!");
            }

            return beamer;
        } catch (java.lang.StringIndexOutOfBoundsException exception) {
            System.out
                    .println("Bitte halte dich an das gegebene Befehlsschema!");
            return false;
        }
    }

    public boolean analyseKaffee(String textKaffee) {
        try {
            boolean kaffee;

            if (textKaffee.trim().equals("v")) {
                kaffee = true;
            } else if (textKaffee.trim().equals("nv")) {
                kaffee = false;
            } else {
                kaffee = false;
                System.out
                        .println("Kaffee-Status nicht lesbar. Status wurde auf nicht vorhanden gesetzt!");
            }

            return kaffee;
        } catch (java.lang.StringIndexOutOfBoundsException exception) {
            System.out
                    .println("Bitte halte dich an das gegebene Befehlsschema!");
            return false;
        }
    }


    public boolean analyseGeschlecht(String textGeschlecht) {
        try {
            boolean geschlecht;

            if (textGeschlecht.trim().equals("Herren")) {
                geschlecht = true;
            } else if (textGeschlecht.trim().equals("Damen")) {
                geschlecht = false;
            } else {
                geschlecht = false;
                System.out
                        .println("Geschlecht nicht lesbar. Status wurde auf Damen gesetzt!");
            }

            return geschlecht;
        } catch (java.lang.StringIndexOutOfBoundsException exception) {
            System.out
                    .println("Bitte halte dich an das gegebene Befehlsschema!");
            return false;
        }
    }


    public int analyseSort(String textSort) {

        try {
            int sort;

            sort = Integer.parseInt(textSort.trim());

            return sort;
        } catch (java.lang.StringIndexOutOfBoundsException exception) {
            System.out
                    .println("Bitte halte dich an das gegebene Befehlsschema!");
            return 0;
        } catch (java.lang.NumberFormatException exception) {
            System.out
                    .println("Kein Sortierparameter!");
            return 0;
        }
    }

    public Analyser() {

    }
}
