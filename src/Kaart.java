import processing.core.PShape;

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
    Kaart(EHoeveelheid hoeveelheid, EKleur kleur, EVorm vorm, EVulling vulling, MainClass app) {
        this.hoeveelheid = hoeveelheid;
        this.kleur = kleur;
        this.vorm = vorm;
        this.vulling = vulling;
        kaart = app.createShape(app.GROUP);
        creatShapeKaart(app);
    }

    public PShape getPShape() {
        return kaart;
    }

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
}
