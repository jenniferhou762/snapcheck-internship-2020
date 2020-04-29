import java.util.*;
import java.lang.Math;

public class SolutionUsingGrid {
    public static String encryption(String s){
        // From description: s only has lower case characters
        // s = s.replace(" ", "");

        // But if s contains Upper cases and Special characters, it works in this way
        s = s.replaceAll("[^a-zA-Z]", "");
        s = s.toLowerCase();

        int len = s.length();
        if(len==0){
            return "";
        }

        int row = (int)(Math.sqrt(len));
        int col = row;
        if(row * row < len){
            col++;
        }
        // ensures that row * col >= len;
        if(row * col < len){
            row++;
        }

        char[][] grid = new char[row][col];
        int t = 0;
        for(int r=0; r<row; r++){
            for(int c=0; c<col && t<len; c++){
                grid[r][c] = s.charAt(t++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                sb.append(grid[j][i]);
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s1 = "have a nice day";
        System.out.println(encryption(s1));

        String s2 = "feed the dog";
        System.out.println(encryption(s2));

        String s3 = "chill out";
        System.out.println(encryption(s3));

        String s4 = "if man was meant to stay on the ground god would have given us roots";
        System.out.println(encryption(s4));

        String s5 = "there is nothing i can do for you";
        System.out.println(encryption(s5));

        String s6 = "what a wonderful day";
        System.out.println(encryption(s6));

        String s7 = "a";
        System.out.println(encryption(s7));

        String s8 = "aaaaaaaaaaaa";
        System.out.println(encryption(s8));

        String s9 = "     abs    de  ";
        System.out.println(encryption(s9));

        String s10 = "a  b";
        System.out.println(encryption(s10));

        String s11 = "a          ";
        System.out.println(encryption(s11));

        String s12 = "            ";
        System.out.println(encryption(s12));

        String s13 = "   #$#@ can you imagine this ?! *&";
        System.out.println(encryption(s13));

        String s14 = "    YOU deserve This!!!!!!  :)";
        System.out.println(encryption(s14));
    }
}
