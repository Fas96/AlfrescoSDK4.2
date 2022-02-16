package LeetCode.GoogleMeet.AtCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q1_C_Repsept {
    public static void main(String[] args) {
//        multiplOfSeven(7,10^6);
        List<Integer> sevArr= multiplOfSeven(7, 1000000);
        solotion(sevArr,2);


    }

    private static void solotion(List<Integer> sevArr,Integer k) {
        List<Integer> integerList = sevArr.stream().filter(e -> e % k == 0).collect(Collectors.toList());


        if(integerList.size()>0){
            Integer resIndex= integerList.get(0);
            System.out.println(sevArr.indexOf(resIndex)+1);
        }else{
            System.out.println(-1);
        }
    }


    private static List<Integer> multiplOfSeven(Integer min, Integer max){
        List<Integer> res= new ArrayList<>();
        for (int i = min; i < max; i++) {
            String stringform = String.valueOf(i);
            int count=0;
            for (int j = 0; j < stringform.length(); j++) {
                if(stringform.charAt(j)=='7'){
                    count+=1;
                }
            }
            if(count==stringform.length()){
                res.add(i);
            }
            
        }
        return res;
    }
}
