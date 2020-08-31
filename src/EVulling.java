/**
 * Enum die bepaald welke vullen een kaart krijg in de figuur per kaart.
 */
public enum EVulling {
    LEEG(0),
    HALFVOL(128),
    VOL(255);
    int i;

    EVulling(int i) {
        this.i = i;
    }

    public int getAlpha() {
        return i;
    }
}
