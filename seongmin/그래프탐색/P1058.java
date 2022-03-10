import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P1058 {
    static boolean[][] arr;
    static int N;
    static Set<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'Y') {
                    arr[i][j] = true;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (arr[i][j]) {
                    set.add(j);
                    friendNum(i, j);
                }
            }
            answer = Math.max(answer, set.size());
        }
        System.out.println(answer);

    }

    static void friendNum(int me, int friend) {
        for (int i = 0; i < N; i++) {
            if (arr[friend][i] && i != me) {
                set.add(i);
            }
        }
    }
}
