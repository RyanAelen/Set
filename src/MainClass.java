import processing.core.PApplet;

public class MainClass extends PApplet {
    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }


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

