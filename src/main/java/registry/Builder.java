package registry;


/**
 * Created by i348490 on Jul, 2021
 **/

@FunctionalInterface
public interface Builder<T> {

    void register(String label, Factory<T> factory);
}
