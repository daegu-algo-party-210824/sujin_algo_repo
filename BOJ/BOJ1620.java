package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ���� ���¾� ���ϸ󸶽��� �̴ټ� : ���ϸ� �������� �̸����� ��ȣ�� ã�� ��ȣ�� �̸� ã�� ����
class BOJ1620 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> foketmap = new HashMap<String, String>();
		
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			String number = Integer.toString(i);
			foketmap.put(name, number);
			foketmap.put(number, name);
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			sb.append(foketmap.get(br.readLine()) + "\n");
		}
		System.out.println(sb);
	}
}
