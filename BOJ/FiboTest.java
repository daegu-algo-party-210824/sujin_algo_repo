package BOJ;

public class FiboTest {
    public int dfs(int n) {
        if(n==1 || n==2)
            return 1;
        else {
            return dfs(n-2) + dfs(n-1);
        }
    }
    public static void main(String[] args) {
        FiboTest C = new FiboTest();

        System.out.println(C.dfs(5));
    }
}
