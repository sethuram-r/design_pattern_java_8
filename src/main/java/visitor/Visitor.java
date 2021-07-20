package visitor;

import java.util.HashMap;
import java.util.Map;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by i348490 on Jul, 2021
 **/


interface Visitor<R> {


    R visit(Object o);

    static Visitor<String> of(Consumer<VisitorBuilder<String>> builderConsumer) {
        Map<Class<?>, Function<Object,String>> registry = new HashMap<>();
        VisitorBuilder<String> builder = new VisitorBuilder<>() {
            @Override
            public <T> void register(Class<T> aclass, Function<T, String> function) {
                 registry.put(aclass,function.compose(aclass::cast));
            }
        };
        builderConsumer.accept(builder);
        return o->registry.get(o.getClass()).apply(o);
    }

    static <T,R> X<T,R> forType(Class<T> cls) {
        return  ()->cls;
    }

    interface X<T,R>{

        Class <T> type();

        default  Y<R> execute(Function<T,R> function){
            return rVisitorBuilder -> rVisitorBuilder.register(type(),function);
        }
    }

    interface Y<R> extends Consumer<VisitorBuilder<R>>{

        default <T>Z<T,R> forType(Class<T> cls){
            return index -> index ==0 ? this:cls;
        }

        default  Y<R> andThen(Y<R> after){
            return t->{
                this.accept(t);
                after.accept(t);
            };
        }

    }

    interface Z<T,R> {

        Object get(int index);

        default Class<T> type(){

            return (Class<T>) get(1);
        }

        default Y<R> previousConsumer(){
            return (Y<R>) get(0);
        }

        default Y<R> execute(Function<T,R> function){
            return previousConsumer().andThen(rVisitorBuilder -> rVisitorBuilder.register(type(),function));
        }
    }



}
