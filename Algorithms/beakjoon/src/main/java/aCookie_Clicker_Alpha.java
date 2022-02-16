import java.util.Scanner;
import java.util.function.Function;

public class aCookie_Clicker_Alpha {
    public static void main(String[] args) {
        System.out.println("-------------------------");

        solution("30.0 25.0 100.0");
        System.out.println("-------------------------");

    }

    private static void solution(int i) {
        for (int j = 0; j < i; j++) {
            Scanner sc=new Scanner(System.in);
            String lineInput = sc.nextLine();
            Double res= solution(lineInput);
        }
    }

    private  static Function<String,Double> parseDb= (Double::parseDouble);

    private static Double solution(String lineInput) {
        String[] s = lineInput.split(" ");
        double C=parseDb.apply(s[0]);
        double F=parseDb.apply(s[1]);
        double X=parseDb.apply(s[2]);

        double CF=0.0;
        if (C<X){X-=C;System.out.println(C/2.0);F+=2;}
        while (true){
            CF = C / F;
            System.out.println(F);
            X-=C;
            F+=F-2;

            if (X-C<C) break;
        }


         return 0.0;
    }
}
