import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1080 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] arrA = new boolean[N][M];
        boolean[][] arrB = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '1') {
                    arrA[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '1') {
                    arrB[i][j] = true;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (arrA[i][j] ^ arrB[i][j]) { // 서로 다르면
                    for (int p = i; p <= i + 2; p++) {
                        for (int q = j; q <= j + 2; q++) {
                            arrA[p][q] = !arrA[p][q];
                        }
                    }
                    answer++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(answer);
    }
}
