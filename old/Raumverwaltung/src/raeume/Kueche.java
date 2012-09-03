package raeume;

public class Kueche extends Raum {
    private boolean kaffee;
    private int gedecke;

    //Getter//
    public String getTextKaffee() {
        String textKaffee;
        if (kaffee) {
            textKaffee = "vorhanden";
        } else {
            textKaffee = "nicht vorhanden";
        }
        return textKaffee;
    }

    public boolean isKaffee() {
        return kaffee;
    }

    public int getGedecke() {
        return gedecke;
    }

    //Setter//

    public void setKaffee(boolean kaffee) {
        this.kaffee = kaffee;
    }

    public void setGedecke(int gedecke) {
        this.gedecke = gedecke;
    }

    public Kueche(String name, int groesse, boolean kaffee, int gedecke) {
        this.setName(name);
        this.setGroesse(groesse);
        this.setTyp("Kueche");
        this.kaffee = kaffee;
        this.gedecke = gedecke;


    }

    public Kueche() {

    }
}
