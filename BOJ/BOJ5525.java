package BOJ;

import java.util.*;

// 백준 5525번: IOIOI
class BOJ5525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int M = Integer.parseInt(sc.nextLine());
		char[] sarr = sc.nextLine().toCharArray();

		int continueCnt = 0, result = 0;

		for(int i=1; i<M-1; i++) {
			if(sarr[i-1] == 'I' && sarr[i] == 'O' && sarr[i+1] == 'I') {
				continueCnt++; // Pn은 IOI가 N만큼 반복되는 것이기에, IOI가 연속으로 N만큼 반복되는지 확인해야한다.
				if(continueCnt == N) {
					result++; // 전체 갯수
					continueCnt--; // continueCnt를 0으로 하면 전체 개수를 찾을 수 없다. 연속되어있는것을 모두 찾는것이기 때문에.
				}
				i++; // 0으로 시작하는 부분은 넘어가고 다음 IOI를 확인해야한다.
			} else {
				continueCnt = 0;
			}
		}
		System.out.println(result);
	}
}
