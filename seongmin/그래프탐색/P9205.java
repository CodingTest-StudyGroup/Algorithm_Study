import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9205 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Node[] shop = new Node[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                shop[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            Node festival = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Queue<Node> q = new LinkedList<>();
            q.add(home);
            boolean[] visited = new boolean[n];
            boolean flag = false;
            while (!q.isEmpty()) {
                Node c = q.poll();
                if (distance(c, festival) <= 1000) {
                    sb.append("happy").append('\n');
                    flag = true;
                    break;
                }
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && distance(c, shop[i]) <= 1000) {
                        q.add(shop[i]);
                        visited[i] = true;
                    }
                }
            }
            if (!flag) {
                sb.append("sad").append('\n');
            }
        }
        System.out.print(sb);
    }

    static int distance(Node start, Node end) {
        return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
