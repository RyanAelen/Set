/**
 * Enum voor de kaarten, bepaald de hoeveelheid van de figuur op 1 kaart staat.
 */
public enum EHoeveelheid {
    EEN(1),
    TWEE(2),
    DRIE(3);
    int i;

    EHoeveelheid(int i) {
        this.i = i;
    }

    public int getNummer() {
        return this.i;
    }
}
