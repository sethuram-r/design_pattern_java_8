package visitor;

import java.util.function.Function;

/**
 * Created by i348490 on Jul, 2021
 **/


public interface VisitorBuilder<R> {

    <T> void register(Class<T> aclass, Function<T,R> function);
}

