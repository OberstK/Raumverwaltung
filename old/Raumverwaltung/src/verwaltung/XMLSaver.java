package verwaltung;

import raeume.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: beku
 * Date: 18.05.12
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class XMLSaver {

public void saveToXMl(ArrayList <Raum> raumListe){

    try {
        XMLEncoder en = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Datenbank.xml")));
        for (Object o : raumListe) {
            en.writeObject(o);
        }
        en.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

}


public ArrayList <Raum> loadFromXL (){
    ArrayList<Raum> raumListe = new ArrayList<Raum>();
    boolean objectsLeft = true;
    try {
        XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("Datenbank.xml")));
        while (objectsLeft) {
            Raum test = (Raum) de.readObject();
            raumListe.add(test);
        }
        de.close();
        return raumListe;

    } catch (java.lang.ArrayIndexOutOfBoundsException e){
        objectsLeft = false;
        return raumListe;

    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return null;
    }

}

}
