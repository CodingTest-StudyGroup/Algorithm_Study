import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int mid = dq.size() / 2;
            int next = Integer.parseInt(st.nextToken());
            int idx = dq.indexOf(next);
            if (mid >= idx) {
                while (true) {
                    int c = dq.pollFirst();
                    if (c == next) {
                        break;
                    } else {
                        dq.addLast(c);
                        answer++;
                    }
                }
            } else {
                while (true) {
                    int c = dq.pollLast();
                    if (c == next) {
                        answer++;
                        break;
                    } else {
                        dq.addFirst(c);
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
