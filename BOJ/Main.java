package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// TODO: 2292, 2869, 2798(재귀로 풀어보기), 1436(규칙을 이용한 풀이해보기), 1931다시복습
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int cntZero = 0, cntOne = 0;

        for(int i=1; i<str.length; i++) {
            if(!str[i-1].equals(str[i])) {
                if(str[i-1].equals("0")) cntZero++;
                else if(str[i-1].equals("1")) cntOne++;
            }
        }

        if(str[str.length-1].equals("0")) cntZero++;
        else if(str[str.length-1].equals("1")) cntOne++;

        System.out.println(Math.min(cntZero, cntOne));
    }
}
