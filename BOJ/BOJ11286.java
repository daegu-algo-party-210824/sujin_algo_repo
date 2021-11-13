package BOJ;

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;

// 절댓값이 작은 순 -> 같다면, 원래 값이 작은 순으로 출력
public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        // 우선순위 큐
        // 자바 힙의 기본 정렬 조건은 최소힙이다. - 오름차순 정렬
        // 선언단계에서 Comparator를 삽입해 정렬 조건을 설정할 수 있다.
        PriorityQueue<Integer> prQue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 > o2 ? 1 : -1; // 절댓값이 같을 때 원래값을 비교, o1이 크면 1 반환, 작으면 -1반환
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        while(N-- >0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) { // 출력 및 삭제
                if(prQue.isEmpty()) sb.append("0\n");
                else sb.append(prQue.poll() + "\n");
            } else { // 값 추가
                prQue.add(num);
            }
        }
        System.out.println(sb);
    }
}
