package raeume;

public class Arbeitsraum extends Raum {
    private boolean beamer;
    private int sitze;

    //Setter//
    public void setBeamer(boolean beamer) {
        this.beamer = beamer;
    }

    public void setSitze(int sitze) {
        this.sitze = sitze;
    }

    //Getter//
    public boolean isBeamer() {
        return beamer;
    }

    public String getTextBeamer() {
        String textBeamer;
        if (beamer) {
            textBeamer = "vorhanden";
        } else {
            textBeamer = "nicht vorhanden";
        }
        return textBeamer;
    }

    public int getSitze() {
        return sitze;
    }

    public Arbeitsraum(String name, int groesse, boolean beamer, int sitze) {
        this.setGroesse(groesse);
        this.setName(name);
        this.setTyp("Arbeitsraum");
        this.beamer = beamer;
        this.sitze = sitze;

    }

    public Arbeitsraum() {

    }
}
