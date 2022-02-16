package FunctionalProg;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Functions {
    public static void main(String[] args) {
        Function<Integer,Integer> incrF= x->  x+=1;
        Function<Integer,Integer> decBY= x->  x-=10;
        BiFunction<Integer,Integer,Integer> incTBY= Integer::sum;
        BiFunction<Integer,Integer,Integer> decTBY= Integer::divideUnsigned;

        System.out.println(decTBY.apply(2,2));

        Function<Integer, Integer> integerVFunction = incrF.andThen(decBY.andThen(decBY.andThen(incrF)));
        System.out.println(integerVFunction.apply(1));

        Integer addTwo = incrF.apply(decBY.apply(100));
        System.out.println(addTwo);

        System.out.println(incrF.apply(1));
        System.out.println(decTBY.apply(1,2));
        System.out.println(decBY.apply(20));
        System.out.println(increment(0));

    }

    static int increment(int number){
        return number+=1;
    }
}
