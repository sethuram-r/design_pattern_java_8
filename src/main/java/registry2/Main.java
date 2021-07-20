package registry2;

import registry.Circle;
import registry.Rectangle;
import registry.Shape;

import java.util.function.Consumer;

/**
 * Created by i348490 on Jul, 2021
 **/


public class Main {

    public static void main(String[] args) {

        Consumer<Builder<Shape>> rectangleConsumer = builder -> builder.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> circleConsumer = builder -> builder.register("circle", Circle::new);

        Consumer<Builder<Shape>> builderConsumer = rectangleConsumer.andThen(circleConsumer);

        Registry<Shape> shapeRegistry = Registry.createRegistry(builderConsumer);

        Factory<Shape> rectangle = shapeRegistry.createFactoryFromRegistry("rectangle");

        System.out.println(rectangle.get().toString());

        Factory<Shape> circle = shapeRegistry.createFactoryFromRegistry("circle");

        System.out.println(circle.get().toString());

    }





}
