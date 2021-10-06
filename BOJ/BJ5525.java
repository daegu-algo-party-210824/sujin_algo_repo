import java.util.*;

// ���� 5525��: IOIOI
class BJ5525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int M = Integer.parseInt(sc.nextLine());
		char[] sarr = sc.nextLine().toCharArray();

		int continueCnt = 0, result = 0;

		for(int i=1; i<M-1; i++) {
			if(sarr[i-1] == 'I' && sarr[i] == 'O' && sarr[i+1] == 'I') {
				continueCnt++; // Pn�� IOI�� N��ŭ �ݺ��Ǵ� ���̱⿡, IOI�� �������� N��ŭ �ݺ��Ǵ��� Ȯ���ؾ��Ѵ�.
				if(continueCnt == N) {
					result++; // ��ü ����
					continueCnt--; // continueCnt�� 0���� �ϸ� ��ü ������ ã�� �� ����. ���ӵǾ��ִ°��� ��� ã�°��̱� ������.
				}
				i++; // 0���� �����ϴ� �κ��� �Ѿ�� ���� IOI�� Ȯ���ؾ��Ѵ�.
			} else {
				continueCnt = 0;
			}
		}
		System.out.println(result);
	}
}
