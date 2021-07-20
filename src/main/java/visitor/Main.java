package visitor;

import java.util.function.Consumer;

/**
 * Created by i348490 on Jul, 2021
 **/


public class Main {

    public static void main(String[] args) {


        Consumer<VisitorBuilder<String>> builderConsumer = Visitor.<Circle,String>forType(Circle.class)
                .execute((Circle c)-> "Here it is "+c)
                .forType(Rectangle.class)
                .execute(r-> "Here it is "+r);


        Visitor<String> visitor = Visitor.of(builderConsumer);

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        System.out.println(visitor.visit(rectangle));
        System.out.println(visitor.visit(circle));



    }
}
