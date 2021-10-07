import java.util.*;

// ���� �躸�� ���� : N - �赵���� ��� M - ���� ���� ��� -> �赵���� ���� ����� ���� �̸� �������� ���
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