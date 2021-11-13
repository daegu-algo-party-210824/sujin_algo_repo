package BOJ;

import javax.swing.text.Position;
import java.io.*;
import java.util.*;

// TODO: 2292, 2869, 2798(재귀로 풀어보기), 1436(규칙을 이용한 풀이해보기), 1931다시복습, 적록색약 문제 복습, 탈출 문제구현어렵다 ㅠㅠ 복습
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int answer = 0, sum, lt = 0;
        int m = s/2+1;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(lt < n) {
            sum = 0;
            for(int rt = lt; rt<n; rt++) {
                sum += arr[rt];
                if(sum == s) {
                    answer++;
                }
            }
            lt++;
        }

        System.out.println(answer);
    }
}
