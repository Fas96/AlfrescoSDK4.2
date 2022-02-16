package FunctionalProg;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        boolean test = isPhoneNumberValidPredicate.test("+32345555");
        boolean negatetest = isPhoneNumberValidPredicate.negate().test("+32345555");
        System.out.println(test);
        System.out.println(negatetest);

        System.out.println(issamenumber.test(1,1));

    }
    static Predicate<String> isPhoneNumberValidPredicate=pnumber->pnumber.startsWith("+")&&pnumber.length()==10;
    static BiPredicate<Integer,Integer> issamenumber=(x,v)-> x==v;
    static boolean isPhoneNumber(String pnum){
        return pnum.startsWith("+");
    }
}
