package raeume;

public class Toilette extends Raum {
    private String sauber;
    private boolean geschlecht;

    //Getter//
    public String getSauber() {
        return sauber;
    }

    public boolean isGeschlecht() {
        return geschlecht;
    }

    public String getTextGeschlecht() {
        String textgeschlecht;

        if (geschlecht) {
            textgeschlecht = "Herren";
        } else {
            textgeschlecht = "Damen";
        }

        return textgeschlecht;
    }


    //Setter
    public void setSauber(String sauber) {
        this.sauber = sauber;
    }


    public void setGeschlecht(boolean geschlecht) {
        this.geschlecht = geschlecht;
    }


    public Toilette(String name, int groesse, String sauber, boolean geschlecht) {
        this.setName(name);
        this.setGroesse(groesse);
        this.setTyp("Toilette");
        this.sauber = sauber;
        this.geschlecht = geschlecht;


    }

    public Toilette() {

    }

}
