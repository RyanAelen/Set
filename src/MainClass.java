import processing.core.PApplet;

import java.util.ArrayList;

public class MainClass extends PApplet {
    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    ArrayList<Kaart> allekaarten;

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
        allekaarten = Kaart.maakkaarten(this);
        println(Kaart.checkIfItsASet(allekaarten.get(1), allekaarten.get(53), allekaarten.get(66)));
        Kaart[] testkaart = new Kaart[4];
        testkaart[0] = new Kaart(EHoeveelheid.EEN, EKleur.GROEN, EVorm.VIERKANT, EVulling.VOL, this);
        testkaart[1] = new Kaart(EHoeveelheid.EEN, EKleur.GROEN, EVorm.VIERKANT, EVulling.VOL, this);
        testkaart[2] = new Kaart(EHoeveelheid.EEN, EKleur.GROEN, EVorm.VIERKANT, EVulling.VOL, this);
        println(Kaart.checkIfItsASet(testkaart));
    }

    @Override
    public void draw() {
        background(0);
        drawAllekaarten();
    }

    private void drawAllekaarten() {
        push();
        int k = 0;
        scale(0.2f);
        for (int i = 0; i < (int) sqrt(allekaarten.size()); i++) {
            for (int j = 0; j < (int) sqrt(allekaarten.size()); j++) {
                if (k < allekaarten.size()) {
                    shape(allekaarten.get(k).getPShape(), i * 100, j * 255);
                    k++;
                }
            }
        }
        pop();
    }

}