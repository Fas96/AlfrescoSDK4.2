package FunctionalProg;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        customerConsumerPrint.accept(new Customer("Fasa","01020120102012"));
        biConsumer.accept(new Customer("Fasa","01020120102012"),45);
    }
    static BiConsumer<Customer,Integer> biConsumer=(c,tf)->{
        System.out.println("the user "+c.customerName+" is "+tf+" and his phone number is "+c.customerphoneNum);
    };
    static Consumer<Customer> customerConsumerPrint=customer -> {
        System.out.println(customer.customerName+"||"+customer.customerphoneNum);
    };


    static class Customer{
        private final String customerName;

        public Customer(String customerName, String customerphoneNum) {
            this.customerName = customerName;
            this.customerphoneNum = customerphoneNum;
        }

        private final String customerphoneNum;
    }
}
