import java.util.*;
import java.io.*;

// 백준 좌표압축 문제 : 좌표압축 Xi > Xj를 충족하는 개수 즉, xi보다 작은 것의 개수 구하기
class BJ18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		String[] sarr = br.readLine().split(" ");

		int[] numarr = new int[N]; // 원래배열
		int[] temp = new int[N];  // 정렬한 배열

		for(int i=0; i<N; i++) {
			numarr[i] = Integer.parseInt(sarr[i]); 
			temp[i] = Integer.parseInt(sarr[i]);
		}
		Arrays.sort(temp);
		
		int idx = 0;
		for(int xi : temp) {
			if(!map.containsKey(xi)) map.put(xi, idx++);
			
		}

		StringBuilder sb = new StringBuilder();
		for(int n : numarr) sb.append(map.get(n) + " ");

		System.out.println(sb.toString());
	}
}
