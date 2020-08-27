/**
 * @author Sanstwy27
 * @create 8/28/2020
 */

interface Foo1 {
    public void sayHello();
}

/**
 * Conceptually, a functional interface has exactly one abstract method.
 * Since default methods have an implementation, they are not abstract.
 * If an interface declares an abstract method overriding one of the public methods of java.lang.Object,
 * that also does not count toward the interface's abstract method count
 * since any implementation of the interface will have an implementation from java.lang.Object or elsewhere.
 */
@FunctionalInterface
interface Foo2 {
    public int add(int x, int y);

    default int div(int x, int y) {
        System.out.println("**** div");
        return x / y;
    }

    public static int mul(int x, int y) {
        System.out.println("**** mul");
        return x * y;
    }
}

public class LambdaExpressDemo {
    public static void main(String[] args) {
        /**
         * Traditional
          */
        /*
        Foo1 foo = new Foo1() {
            @Override
            public void sayHello() {
                System.out.println("1. ***** hello java!");
            }
        };
        foo.sayHello();
         */

        /**
         * LambdaExpress
         */
        Foo1 fooHello = () -> {System.out.println("2. ***** hello java!");};
        fooHello.sayHello();

        Foo2 fooCal = (x, y) -> { System.out.println("**** add"); return x + y;};
        System.out.println(fooCal.add(3, 5));
        System.out.println(fooCal.div(10, 5));
        System.out.println(Foo2.mul(3,5));
    }
}
