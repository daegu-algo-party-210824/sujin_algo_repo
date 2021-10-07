import java.util.*;

// 백준 듣보잡 문제 : N - 듣도못한 사람 M - 보도 못한 사람 -> 듣도보도 못한 사람의 수와 이름 오름차순 출력
class BJ1764 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		sc.nextLine();

		for(int i=0; i<N+M; i++) {
			String name = sc.nextLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		ArrayList<String> list = new ArrayList<String>();

		for(String key : map.keySet()) {
			if(map.get(key) == 2) list.add(key);
		}
		list.sort(Comparator.naturalOrder());
		
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));	
		}
	}
}