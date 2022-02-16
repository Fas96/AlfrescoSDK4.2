package FunctionalProg;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
//        getdatabaseURL.get();
        System.out.println(getdatabaseURL.get());
        System.out.println(getdatabaseURLS.get());
//         getdatabaseURLS.
    }

    static Supplier<String> getdatabaseURL=()->"fasgh.govt.kr";
    static Supplier<List<String>> getdatabaseURLS=()-> List.of("fasgh.govt.kr","argonet.co.kr");
}
