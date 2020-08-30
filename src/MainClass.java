import processing.core.PApplet;

import java.util.ArrayList;

public class MainClass extends PApplet {
    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    ArrayList<Kaart> alleKaarten;

    @Override
    public void settings() {
        size(400, 400, P3D);
        smooth(8);

    }

    @Override
    public void setup() {
        surface.setResizable(true);
        surface.setTitle(this.getClass().getName());
        frameRate(144);
        alleKaarten = Kaart.maakKaarten(this);
        println(Kaart.checkIfItsASet(alleKaarten.get(1), alleKaarten.get(53), alleKaarten.get(66)));
        Kaart[] testkaart = new Kaart[3];
        testkaart[0] = new Kaart(EHoeveelheid.EEN, EKleur.GROEN, EVorm.VIERKANT, EVulling.VOL, this);
        testkaart[1] = new Kaart(EHoeveelheid.EEN, EKleur.GROEN, EVorm.VIERKANT, EVulling.VOL, this);
        testkaart[2] = new Kaart(EHoeveelheid.EEN, EKleur.GROEN, EVorm.VIERKANT, EVulling.VOL, this);
        println(Kaart.checkIfItsASet(testkaart));
    }

    @Override
    public void draw() {
        background(0);
        drawAlleKaarten();
    }

    private void drawAlleKaarten() {
        push();
        int k = 0;
        scale(0.2f);
        for (int i = 0; i < (int) sqrt(alleKaarten.size()); i++) {
            for (int j = 0; j < (int) sqrt(alleKaarten.size()); j++) {
                if (k < alleKaarten.size()) {
                    shape(alleKaarten.get(k).getPShape(), j * 100, i * 255);
                    fill(0);
                    textSize(60);
                    text("" + k, j * 100, i * 255 + 200);
                    k++;
                }
            }
        }
        pop();
    }

}