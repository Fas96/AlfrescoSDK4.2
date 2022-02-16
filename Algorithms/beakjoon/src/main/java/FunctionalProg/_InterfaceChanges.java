package FunctionalProg;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.UnaryOperator;

interface List<E> extends Collection<E>  {
    default void  replaceAll(UnaryOperator<E> operator){
        Objects.requireNonNull(operator);
        final ListIterator<E> li= (ListIterator<E>) this.stream().toList();
        while (li.hasNext()){
            li.set(operator.apply(li.next()));
        }
    }
    default  void  sort(Comparator<? super E> c){
        Object[] a = this.toArray();
        Arrays.sort(a,(Comparator) c);
        ListIterator<E> i = (ListIterator<E>) this.stream().toList();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }
}
