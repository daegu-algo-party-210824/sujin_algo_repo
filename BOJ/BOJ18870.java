package BOJ;

import java.util.*;
import java.io.*;

// ���� ��ǥ���� ���� : ��ǥ���� Xi > Xj�� �����ϴ� ���� ��, xi���� ���� ���� ���� ���ϱ�
class BOJ18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		String[] sarr = br.readLine().split(" ");

		int[] numarr = new int[N]; // �����迭
		int[] temp = new int[N];  // ������ �迭

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
