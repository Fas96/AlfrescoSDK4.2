package FunctionalProg.streams;

import java.util.Optional;

public class _Optionals {
    public static void main(String[] args) {

        Optional<String> check= Optional.ofNullable(null);
        Optional.empty().filter(e-> Boolean.parseBoolean(e.toString()));
        Optional.ofNullable(null).orElseGet(()->"the values does not exxist");
        System.out.println(Optional.ofNullable(null).orElseGet(()->"the values does not exxist"));

        System.out.println(Optional.empty().filter(e-> Boolean.parseBoolean(e.toString())));
        check.ifPresentOrElse(System.out::println,()->{
            System.out.println("values does not exist");
        });

    }
}
