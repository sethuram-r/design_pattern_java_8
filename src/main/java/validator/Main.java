package validator;



/**
 * Created by i348490 on Jul, 2021
 **/


public class Main {

    public static void main(String[] args) {

        Person sunny = new Person("Sunny",22);
        Person bunny = new Person("Bunny",-10);
        Person munny = new Person(null,22);
        Person dunny = new Person(null,-15);


        dunny = Validator
                .validate(p-> p.getName() !=null, "Name should not be null")
                .thenValidate(p-> p.getAge() > 0, "Age should not be negative")
                .on(dunny)
                .validate();


        System.out.println(dunny.toString());

    }
}
