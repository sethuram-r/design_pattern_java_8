package validator;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by i348490 on Jul, 2021
 **/


public interface Validator {


    PersonSupplier on(Person p);

    default Validator thenValidate(Predicate<Person> personPredicate, String errorMessage){
        return p -> {
            try{
                on(p).validate();
                if (personPredicate.test(p)) {
                    return () -> p;
                } else {
                    RuntimeException e = new RuntimeException("Invalid");
                    e.addSuppressed(new IllegalArgumentException(errorMessage));
                    return ()->{throw e;};
                }

            }catch (RuntimeException e){

                if (personPredicate.test(p)) {
                    return ()->{throw e;};
                } else {
                    e.addSuppressed(new IllegalArgumentException(errorMessage));
                    return ()->{throw e;};
                }

            }

        };
    }


    static Validator validate(Predicate<Person> personPredicate, String errorMessage) {
        return p -> {
            System.out.println("inside validate");
            if (personPredicate.test(p)) {
                return () -> p;
            } else {

                RuntimeException e = new RuntimeException("Invalid");
                e.addSuppressed(new IllegalArgumentException(errorMessage));
                return ()->{throw e;};
            }
        };
    }

    interface PersonSupplier extends Supplier<Person> {

        default Person validate() {
            return get();
        }
    }


}
