import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 1));

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int dis = q.peek().dis;
            int check = q.poll().check;
            if (x == N - 1 && y == M - 1) {
                answer = Math.min(answer, dis);
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                /**
                 * visited의 값은 1 or MAX or 0. check는 0 or 1.
                 * 누가 벽을 부수고 간 길이면 visited의 값은 1이됨. => 내가 벽을 부순적이 없으면 갈 수 있음.
                 * 아직 아무도 안갔으면 visited의 값은 MAX. => 벽이냐 아니냐에 따라 갈 수 있는 여부 판단.
                 * 벽을 부수지 않고 갔으면 visited의 값은 0. => 누구나 갈 수 있음.
                 */
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] > check) {
                    if (check == 0 && arr[nx][ny] == 1) { //벽일때
                        visited[nx][ny] = check + 1;
                        q.offer(new Node(nx, ny, check + 1, dis + 1));
                    } else if (arr[nx][ny] == 0) { //벽이 아닐때
                        visited[nx][ny] = check;
                        q.offer(new Node(nx, ny, check, dis + 1));
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, dis, check;

        public Node(int x, int y, int check, int dis) {
            this.x = x;
            this.y = y;
            this.check = check;
            this.dis = dis;
        }
    }
}
