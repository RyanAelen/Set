/**
 * Enum voor het bepalen van de kleur van de figuur op de kaart
 */
public enum EKleur {
    ROOD(255, 0, 0),
    PAARS(255, 0, 255),
    GROEN(0, 255, 0);
    int r, g, b;

    EKleur(int i, int i1, int i2) {
        this.r = i;
        this.g = i1;
        this.b = i2;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}
