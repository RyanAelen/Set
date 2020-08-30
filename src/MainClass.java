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

    }

    @Override
    public void draw() {
        background(0);

    }
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