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

}
