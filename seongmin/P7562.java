import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    static int N;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            Queue<Node> q = new LinkedList<>();
            q.add(start);
            boolean[][] visited = new boolean[N][N];
            visited[start.x][start.y] = true;
            if (start.x == end.x && start.y == end.y) {
                sb.append(0).append('\n');
            } else {
                loop:
                while (!q.isEmpty()) {
                    Node c = q.poll();
                    for (int i = 0; i < 8; i++) {
                        int nx = c.x + dx[i];
                        int ny = c.y + dy[i];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                            if (nx == end.x && ny == end.y) {
                                sb.append(c.cnt + 1).append('\n');
                                break loop;
                            }
                            q.add(new Node(nx, ny, c.cnt + 1));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        System.out.print(sb);
    }

    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
