import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2448 {
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }
        solution(N, 0, N - 1);
        StringBuilder sb = new StringBuilder();
        for (char[] chars : arr) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void solution(int n, int x, int y) {
        if (n == 3) {
            arr[x][y] = '*';
            arr[x + 1][y - 1] = arr[x + 1][y + 1] = '*';
            arr[x + 2][y - 2] = arr[x + 2][y - 1] = arr[x + 2][y] = arr[x + 2][y + 1] = arr[x + 2][y + 2] = '*';
            return;
        }
        solution(n / 2, x, y);
        solution(n / 2, x + n / 2, y - n / 2);
        solution(n / 2, x + n / 2, y + n / 2);

    }
}
