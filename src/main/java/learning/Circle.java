package learning;

import java.awt.*;

/**
 * Created by i348490 on Jul, 2021
 **/


public class Circle {

    private Color color;

    public Circle() {
        this.color = Color.black;
    }

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{"+color+"}";
    }
}
