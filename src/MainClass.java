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
        maakkaarten();
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

    public void maakkaarten() {
        allekaarten = new ArrayList<>();
        for (int i = 0; i < EHoeveelheid.values().length; i++) {
            for (int j = 0; j < EKleur.values().length; j++) {
                for (int k = 0; k < EVorm.values().length; k++) {
                    for (int l = 0; l < EVulling.values().length; l++) {
                        allekaarten.add(new Kaart(EHoeveelheid.values()[i], EKleur.values()[j], EVorm.values()[k], EVulling.values()[l], this));
                    }
                }
            }
        }
    }
}