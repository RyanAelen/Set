import com.sun.istack.internal.NotNull;
import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;

public class Kaart {
    public EHoeveelheid hoeveelheid;
    public EKleur kleur;
    public EVorm vorm;
    public EVulling vulling;
    private final PShape kaart;

    /**
     * @param hoeveelheid Bepaal nummer
     * @param kleur       Bpaal de kleur
     * @param vorm        Bepaal de vorm
     * @param vulling     Bepaal de vulling
     */
    Kaart(@NotNull EHoeveelheid hoeveelheid, @NotNull EKleur kleur, @NotNull EVorm vorm, @NotNull EVulling vulling, @NotNull MainClass app) {
        if (app != null) {
            this.hoeveelheid = hoeveelheid;
            this.kleur = kleur;
            this.vorm = vorm;
            this.vulling = vulling;
            kaart = app.createShape(app.GROUP);
            creatShapeKaart(app);
        } else {
            throw new NullPointerException("De app Mainclass is null in Constructor Kaart class");
        }
    }

    /**
     * @return Pshape of een kaart
     */
    public PShape getPShape() {
        return kaart;
    }

    /**
     * @param app De MainClass App
     */
    void creatShapeKaart(MainClass app) {
        PShape[] figuren;
        PShape background;
        int r, g, b, a;
        if (kaart != null && app != null) {
            r = 0;
            g = 0;
            b = 0;
            a = 255;
            switch (kleur) {
                case ROOD:
                    r = 255;
                    break;
                case GROEN:
                    g = 255;
                    break;
                case PAARS:
                    r = 255;
                    b = 255;
                    break;
            }
            switch (vulling) {
                case VOL:
                    //a is all 255
                    break;
                case LEEG:
                    a = 0;
                    break;
                case HALFVOL:
                    a = 128;
                    break;
            }
            switch (hoeveelheid) {
                case EEN:
                    figuren = new PShape[1];
                    break;
                case TWEE:
                    figuren = new PShape[2];
                    break;
                case DRIE:
                    figuren = new PShape[3];
                    break;
                default:
                    figuren = new PShape[0];
            }
            switch (vorm) {
                case DRIEHOEK:
                    for (int i = 0; i < figuren.length; i++) {
                        figuren[i] = app.createShape(app.TRIANGLE, 0, 0, 50, 0, 25, 50);
                        figuren[i].translate(25, i * 75 + 25);
                    }

                    break;
                case ROND:
                    for (int i = 0; i < figuren.length; i++) {
                        figuren[i] = app.createShape(app.ELLIPSE, 0, 0, 50, 50);
                        figuren[i].translate(50, i * 75 + 50);
                    }

                    break;
                case VIERKANT:
                    for (int i = 0; i < figuren.length; i++) {
                        figuren[i] = app.createShape(app.RECT, 0, 0, 50, 50);
                        figuren[i].translate(25, i * 75 + 25);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + vorm);
            }

            background = app.createShape(app.RECT, 0, 0, 100, 250);
            background.setFill(app.color(255));
            kaart.addChild(background);
            for (PShape pShape : figuren) {
                pShape.setFill(app.color(r, g, b, a));
                pShape.setStroke(app.color(r, g, b));
                pShape.setStrokeWeight(3);
                kaart.addChild(pShape);
            }
        }
    }//end function

    /**
     * @param app De main ClassApp
     * @return een arraylist met de 81 mogelijken aan kaarten
     */
    static public ArrayList<Kaart> maakkaarten(@NotNull MainClass app) {
        if (app == null) {
            throw new IllegalArgumentException("Het maken van alle kaarten is niet gelukt om dat de app null is");
        }
        ArrayList<Kaart> allekaarten = new ArrayList<>();
        for (int i = 0; i < EHoeveelheid.values().length; i++) {
            for (int j = 0; j < EKleur.values().length; j++) {
                for (int k = 0; k < EVorm.values().length; k++) {
                    for (int l = 0; l < EVulling.values().length; l++) {
                        allekaarten.add(new Kaart(EHoeveelheid.values()[i], EKleur.values()[j], EVorm.values()[k], EVulling.values()[l], app));
                    }
                }
            }
        }
        return allekaarten;
    }

    /**
     * @param kaarten Array met minimaal 3 Kaarten er in.
     * @return True Wanner er een set is, False Waneer er geen set is.
     */
    static public boolean checkIfItsASet(Kaart[] kaarten) {
        if (kaarten.length == 3) {
            for (int i = 0; i < 3; i++) {
                if (kaarten[i] == null) {
                    throw new IllegalArgumentException("Kaart op index " + i + " in de array is null");
                }
            }
            return checkIfItsASet(kaarten[0], kaarten[1], kaarten[2]);
        }
        throw new IllegalArgumentException("Kaart Array met " + kaarten.length + " grote is niet toegestaan.");
    }

    /**
     * @param een  eerste kaart
     * @param twee tweede kaart
     * @param drie derde kaart
     * @return True Wanner er een set is, False Waneer er geen set is.
     * @throws IllegalArgumentException Wanneer er een null word mee gegeven.
     */
    static public boolean checkIfItsASet(@NotNull Kaart een, @NotNull Kaart twee, @NotNull Kaart drie) {
        if (een == null || twee == null || drie == null) {
            throw new IllegalArgumentException("Een of meer van de kaarten zijn NULL");
        }
        return (nummersEenSet(een, twee, drie) && kleurEenSet(een, twee, drie) && vormEenSet(een, twee, drie) && vullingEenSet(een, twee, drie));
    }

    /**
     * @param een  eerste kaart
     * @param twee tweede kaart
     * @param drie derde kaart
     * @return True Wanner De nummers een set vormen.
     */
    static public boolean nummersEenSet(Kaart een, Kaart twee, Kaart drie) {
        PApplet.println("" + een.hoeveelheid + twee.hoeveelheid + drie.hoeveelheid);
        boolean temp = false;
        if (een.hoeveelheid == twee.hoeveelheid & een.hoeveelheid == drie.hoeveelheid) {
            temp = true;
        }
        if (een.hoeveelheid != twee.hoeveelheid && twee.hoeveelheid != drie.hoeveelheid && drie.hoeveelheid != een.hoeveelheid) {
            temp = true;
        }
        return temp;
    }

    /**
     * @param een  eerste kaart
     * @param twee tweede kaart
     * @param drie derde kaart
     * @return True wanneer de kleuren een set formen.
     */
    static public boolean kleurEenSet(Kaart een, Kaart twee, Kaart drie) {
        PApplet.println("" + een.kleur + twee.kleur + drie.kleur);
        boolean temp = false;
        if (een.kleur == twee.kleur & een.kleur == drie.kleur) {
            temp = true;
        }
        if (een.kleur != twee.kleur && twee.kleur != drie.kleur && drie.kleur != een.kleur) {
            temp = true;
        }
        return temp;
    }

    /**
     * @param een  eerste kaart
     * @param twee tweede kaart
     * @param drie derde kaart
     * @return True Wanneer de vorm een set vormt
     */
    static public boolean vormEenSet(Kaart een, Kaart twee, Kaart drie) {
        PApplet.println("" + een.vorm + twee.vorm + drie.vorm);
        boolean temp = false;
        if (een.vorm == twee.vorm & een.vorm == drie.vorm) {
            temp = true;
        }
        if (een.vorm != twee.vorm && twee.vorm != drie.vorm && drie.vorm != een.vorm) {
            temp = true;
        }
        return temp;
    }

    /**
     * @param een  eerste kaart
     * @param twee tweede kaart
     * @param drie derde kaart
     * @return True Wanneer de vulling een set vormt
     */
    static public boolean vullingEenSet(Kaart een, Kaart twee, Kaart drie) {
        PApplet.println("" + een.vulling + twee.vulling + drie.vulling);
        boolean temp = false;
        if (een.vulling == twee.vulling & een.vulling == drie.vulling) {
            temp = true;
        }
        if (een.vulling != twee.vulling && twee.vulling != drie.vulling && drie.vulling != een.vulling) {
            temp = true;
        }
        return temp;
    }

}
