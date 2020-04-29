import java.util.*;
import java.lang.Math;

public class Solution {
    public static String encryption(String s){
        // As required: s is comprised only of characters in the range ascii[a-z].
        // s = s.replace(" ", "");

        // But if s contains Upper cases and special characters, it works in this way.
        s = s.replaceAll("[^a-zA-Z]", "");
        s = s.toLowerCase();

        int len = s.length();
        // actually this is unnecessary, but can shorten the process in this case
        if(s.length()==0) {
            return "";
        }

        int row = (int)(Math.sqrt(len));
        int col = row;
        if(row * row < len) {
            col++;
        }
        // ensures that row * col >= len;
        if(row * col < len){
            row++;
        }

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<col; j++){
            int i = j;
            while(i < len){
                char ch = s.charAt(i);
                sb.append(ch);
                i += col;
            }
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args){
        // case s1 - s12: only lower cases and spaces
        // case s13 - s14: ++ upper cases and special characters
        String s1 = "have a nice day";
        System.out.println(encryption(s1));

        String s2 = "feed the dog";
        System.out.println(encryption(s2));

        String s3 = "chill our";
        System.out.println(encryption(s3));

        String s4 = "if man  was meant to stay on the ground god would have given us roots";
        System.out.println(encryption(s4));

        String s5 = "there is nothing i can do for you";
        System.out.println(encryption(s5));

        String s6 = "what a wonderful day";
        System.out.println(encryption(s6));

        String s7 = "a";
        System.out.println(encryption(s7));

        String s8 = "aaaaaaaaaaaa";
        System.out.println(encryption(s8));

        String s9 = "    abs   de  ";
        System.out.println(encryption(s9));

        String s10 = "a b";
        System.out.println(encryption(s10));

        String s11 = "a   ";
        System.out.println(encryption(s11));

        String s12 = "        ";
        System.out.println(encryption(s12));

        String s13 = "  @@@  can you imagine this?!!!";
        System.out.println(encryption(s13));

        String s14 = "   YOU deserve this!!!";
        System.out.println(encryption(s14));

    }
}
