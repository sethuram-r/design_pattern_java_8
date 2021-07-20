package registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by i348490 on Jul, 2021
 **/

@FunctionalInterface
public interface Registry {

    Factory<Rectangle> buildShapeFactory(String shape);

     static Registry createRegistry(Consumer<Builder<Rectangle>> builderConsumer){
        Map<String,Factory<Rectangle>> registry = new HashMap<>();
        Builder<Rectangle> builder = (label, factory) -> registry.put(label,factory);
        builderConsumer.accept(builder);
        return shape->registry.get(shape);
    }


}
