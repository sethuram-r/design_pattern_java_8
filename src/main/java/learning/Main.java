package learning;


import java.awt.*;
import java.util.List;

/**
 * Created by i348490 on Jul, 2021
 **/


public class Main {

    public static void main(String[] args) {

        Factory<Circle> circleFactory = Factory.createFactory(Circle::new,Color.BLUE);

        Circle circle =  circleFactory.newInstance();
        System.out.println(circle.toString());

        List<Circle> circles = circleFactory.create5();
        System.out.println("Size ->"+ circles.size());

    }


}
