package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2178 {
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int[] dy = {-1, 0, 1, 0}; // 상하
    static int[] dx = {0, -1, 0, 1}; // 좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m]; // 맵생성
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int y, int x) {
        Queue<Now> que = new LinkedList<Now>();
        que.add(new Now(y, x));

        while(!que.isEmpty()) {
            Now now = que.poll();

            for(int i=0; i<4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                if(checkNow(nextY, nextX)) {
                    que.add(new Now(nextY, nextX));
                    map[nextY][nextX] = map[now.y][now.x]+1;
                    visited[nextY][nextX] = true;
                }
            }
        }

    }

    public static boolean checkNow(int y, int x) {
        // 노드가 범위 밖인 경우
        if(y < 0 || y >= n || x < 0 || x >= m) return false;
        // 이미 방문한 노드이거나 0이라서 못가는 길인 경우
        if(visited[y][x] == true || map[y][x] == 0) return false;
        return true;
    }
}

class Now {
    int y;
    int x;

    public Now(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
