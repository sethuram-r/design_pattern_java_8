package registry2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by i348490 on Jul, 2021
 **/


public interface Registry<T> {

    Factory<T> createFactoryFromRegistry (String label);


    static <T> Registry<T> createRegistry(Consumer<Builder<T>> builderConsumer){
        Map<String,Factory<T>> registry = new HashMap<>();
        Builder<T> builder = (label, factory) -> registry.put(label,factory);
        builderConsumer.accept(builder);
        return (label) -> registry.get(label);
    }

}
