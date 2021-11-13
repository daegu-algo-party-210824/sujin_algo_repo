package BOJ;

import java.io.*;
import java.util.*;

public class BOJ6593 {
    static int count, l, r, c;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dz = {0, 0, 0, 0, -1, 1}; // 위아래
    static int[] dy = {-1, 0, 1, 0, 0, 0}; // 북남
    static int[] dx = {0, -1, 0, 1, 0, 0}; // 서동
    static Queue<Location> que;
    static Location end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0) break; // 종료조건

            building = new char[l][r][c];
            visited = new boolean[l][r][c];
            que = new LinkedList<>();

            for(int i=0; i<l; i++) {
                for(int j=0; j<r; j++) {
                    String str = br.readLine();
                    if(str.equals("")) str = br.readLine(); // 층 구별 공백만나면 다음 입력으로 넘어감.

                    for(int k=0; k<c; k++) {
                        char ch = str.charAt(k);
                        if(ch == 'S') {
                            que.add(new Location(i, j, k));
                            visited[i][j][k] = true;
                        }	else if(ch == 'E') end = new Location(i, j, k);
                        building[i][j][k] = ch;
                    }
                }
            }
            count = 0; // 초기화 주의!
            while(!que.isEmpty()) {
                bfs();
            }

            if(end == null) {
                System.out.println("Trapped!");
            } else {
                sb.append(visited[end.z][end.y][end.x] ? "Escaped in "+ count + " minute(s).\n" : "Trapped!\n");
            }

        }
        System.out.println(sb);
    }

    public static void bfs() {
        int qsize = que.size();
        while(qsize-- > 0) {
            Location now = que.poll();

            for(int i=0; i<6; i++) {
                int nz = now.z + dz[i];
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(valCheck(nz, ny, nx)) {
                    if(building[nz][ny][nx] == 'E') {
                        visited[nz][ny][nx] = true;
                        count++;
                        que.clear();
                        return;
                    }

                    if(building[nz][ny][nx] == '.') {
                        que.add(new Location(nz, ny, nx));
                        visited[nz][ny][nx] = true;
                    }
                }
            }
        }
        count++;
    }

    public static boolean valCheck(int nz, int ny, int nx) {
        if(nz < 0 || nz >= l || ny < 0 || ny >= r || nx < 0 || nx >= c || visited[nz][ny][nx])
            return false;
        return true;
    }

}

class Location {
    int z;
    int y;
    int x;

    public Location (int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }
}
