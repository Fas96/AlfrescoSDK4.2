package FunctionalProg;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _ImproveTypeInference {
    public static void main(String[] args) {
        Map<String, List<Trade>> trades= new TreeMap<>();
        trades.put("a",List.of(new Trade("BNB",5.3),new Trade("NANO",2.3)));
        trades.put("b",List.of(new Trade("NANO",2.3),new Trade("BNB",5.3)));

        System.out.println(trades);
        String status=null;
        if(status!=null){
            switch (status){
                case "NEW":
                case "INSERTED":
                    System.out.println("new Trade"); break;
                case "DELETED":
                    System.out.println("DELETED trade"); break;
                case "UPDATED":
                    System.out.println("UPDATE the trade"); break;
            }
        }

        //FileIS is FileInputStream
        //FileOS is FileOutputStream
        try(InputStream in = new FileInputStream("");
            OutputStream out= new FileOutputStream("");){
            readAndWrite(in,out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private static void readAndWrite(InputStream in, OutputStream out) {
    }

    static class Trade{
        private String title;
        private double price;

        @Override
        public String toString() {
            return "[" +
                    "Title='" + title + '\'' +
                    ", price=" + price +
                    ']';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Trade(String title, double price) {
            this.title = title;
            this.price = price;
        }
    }
}
