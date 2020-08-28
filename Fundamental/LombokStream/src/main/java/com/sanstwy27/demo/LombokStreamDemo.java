package com.sanstwy27.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Data
@NoArgsConstructor
@AllArgsConstructor
class User
{
    private Integer id;
    private String  userName;
    private int     age;
}

public class LombokStreamDemo {

    public static void main(String[] args) {

        /**
         * R apply(T t);
         */
        Function<String,Integer> function = t -> {return t.length();};
        // === Function<String,Integer> function = t -> t.length();
        System.out.println(function.apply("abc"));

        /**
         * boolean test(T t);
         */
        Predicate<String> predicate = t -> {return t.startsWith("a");};
        // === Predicate<String> predicate = t -> t.startsWith("a");
        System.out.println(predicate.test("a"));

        /**
         * void accept(T t);
         */
        Consumer<String> consumer = t -> {System.out.println(t);};
        consumer.accept("java1234");

        /**
         * T get();
         */
        Supplier<String> supplier =  () -> {return UUID.randomUUID().toString();};
        // === Supplier<String> supplier =  () -> UUID.randomUUID().toString();
        System.out.println(supplier.get());

        /**
         * SELECT * FROM user WHERE id % 2 == 0 AND age > 24 ORDER BY userName LIMIT 1 ?
         */
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream().filter(p -> {
            return p.getId() % 2 == 0;
        }).filter(p -> {
            return p.getAge() > 24;
        }).map(f -> {
            return f.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(2).forEach(System.out::println);

        /**
         * ---- Result ----
         * 3
         * true
         * java1234
         * d73f4756-449f-41d7-b00c-7f6b94cffa34
         * E
         * D
         */
    }

}
