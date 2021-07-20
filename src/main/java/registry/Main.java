package registry;

import java.util.function.Consumer;

/**
 * Created by i348490 on Jul, 2021
 **/


public class Main {

    // a way to build registry

  public static void main(String[] args) {

    Consumer<Builder<Rectangle>> consumer = builder -> builder.register("rectangle",Rectangle::new);

    Registry registry = Registry.createRegistry(consumer);
    Factory<Rectangle> rectangle = registry.buildShapeFactory("rectangle");
    System.out.println(rectangle.newInstance().toString());
  }




}
