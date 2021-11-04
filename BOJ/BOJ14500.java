package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://junco.tistory.com/64 - 다른 풀이방법
public class BOJ14500 {
    static int N, M;
    static int max = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상 좌 하 우
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new int[N][M]; // N*M종이
        visited = new boolean[N][M]; // 방문체크

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // end of input

        tetromino();

        System.out.println(max);
    }

    public static void tetromino() { // map전체 탐색
        for(int i=0; i<N; i++) {
            for(int j=0; i<M; j++) {
                dfs(i, j, 0, 0); // 'ㅗ'제외 나머지 모양들

            }
        }
    }

    // 'ㅗ'제외 나머지 모양들
    public static int dfs(int row, int col, int depth, int sum) {
        if(depth == 4) { // 테트로미노는 정사각형4개가 연결된것
            max = Math.max(max, sum);
            return 0;
        }

        for(int i=0; i<4; i++) { // 테트로미노는 정사각형4개가 연결된것
            int nextX = row + dx[i]; // 상 좌 하 우 방향으로 탐색
            int nextY = col + dy[i];

            if(nextX < 0|| nextY < 0 || nextX > N || nextY > M) // 종이판 범위 밖일 때
                continue;
            if(visited[nextX][nextY]) // 이미 방문 했을 때
                continue;

            visited[nextX][nextY] = true;
            dfs(nextX, nextY, depth+1, sum+map[nextX][nextY]);
            visited[nextX][nextY] = false;
        }
        return 1;
    }
}
