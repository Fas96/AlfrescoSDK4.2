package LeetCode.GoogleMeet.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q2_CountUniqueCharactersAllSubstringsGivenString {


    public static void main(String[] args) {
        List<String> abc = generateSubSeq("LEETCODE");
        for (String s : abc) {
            List<List> leetcode = countChars(s);
            List collect = leetcode.get(1);
            List<String> res= new ArrayList<>();

            for (int i = 0; i < collect.size(); i++) {
                if(leetcode.get(1).get(i).equals(1)){
                    leetcode.get(0).get(i);
                    res.add(  leetcode.get(0).get(i)+"");
                }
            }
            System.out.println(res);
        }



    }

    public static List<List> countChars(String str){
        char[] strArr;
        List<Character> characterList= new ArrayList<>();
        List<Integer> characteCount= new ArrayList<>();
        while(str.length() != 0){
            strArr = str.toCharArray();
            char ch = strArr[0];
            int count = 1;
            for(int i = 1; i < strArr.length; i++){
                if(ch == strArr[i]){
                    count++;
                }
            }
            if(((ch != ' ') && (ch != '\t'))){
                characterList.add(ch);
                characteCount.add(count);
            }
            // replace all occurrence of the character
            // which is already iterated and counted

            str = str.replace(""+ch, "");
        }
        return List.of(characterList,characteCount);
    }

    private static List<String> generateSubSeq(String gi){
        List<String> sub = new ArrayList<>();
        for (int i = 0; i < gi.length(); i++) {
            sub.add(gi.charAt(i)+"");
        }
        for (int i = 0; i < gi.length(); i++) {
            sub.add(gi.substring(i)+"");
        }
        return sub;
    }

}
