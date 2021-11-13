package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        String str = "";
        for(int i=1; i<=n; i++) {
            str += br.readLine();
        }

        System.out.println(str);
    }
}
