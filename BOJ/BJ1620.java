import java.util.*;

// 백준 나는야 포켓몬마스터 이다솜 : 포켓몬 도감에서 이름으로 번호를 찾고 번호로 이름 찾는 문제
class BJ1620 {
	public static void main(String[] args) {
	
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
