package registry2;

import java.util.function.Supplier;

/**
 * Created by i348490 on Jul, 2021
 **/


public interface Factory<T> extends Supplier<T> {

    static <T> Factory<T> createFactory(Supplier<T> supplier){
        var singleton = supplier.get();
        return () -> singleton;
    }
}
