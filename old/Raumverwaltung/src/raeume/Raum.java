package raeume;

public class Raum implements Comparable<Raum> {

    private String name;
    private int groesse;
    private String typ;


    // Getter //
    public String getName() {
        return name;
    }

    public int getGroesse() {
        return groesse;
    }

    public String getTyp() {
        return typ;
    }

    // Setter //

    public void setName(String name) {
        this.name = name;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }


    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public int compareTo(Raum raum) {
        return this.getName().compareToIgnoreCase(raum.getName());
    }
}
