package raeume;

public class Konferenzraum extends Raum {

    private boolean status;

    public String getTextStatus() {
        String textStatus = null;

        if (status) {
            textStatus = "frei";
        } else {
            textStatus = "belegt";
        }

        return textStatus;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public Konferenzraum(String name, int groesse, boolean status) {
        this.setName(name);
        this.setGroesse(groesse);
        this.setTyp("Konferenzraum");
        this.setStatus(status);
    }

    public Konferenzraum() {

    }
}
