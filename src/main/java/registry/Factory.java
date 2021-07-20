package registry;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by i348490 on Jul, 2021
 **/


public interface Factory<T> extends Supplier<T> {

    static<T> Factory<T> createFactory(Supplier<T> supplier) {
        var singleton = supplier.get();
        return ()->singleton;
    }

    static <T,R> Factory<T> createFactory(Function<R,T> function,R color) {
        return ()->function.apply(color);
    }


    default T newInstance(){
        return this.get();
    }


    default List<T> create5(){
        return IntStream.range(0,5)
                .mapToObj(value -> newInstance())
                .collect(Collectors.toList());
    }
}
