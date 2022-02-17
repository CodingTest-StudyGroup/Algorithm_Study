import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1449 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double L = Double.parseDouble(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        L -= 0.5;
        int answer = N;
        Arrays.sort(arr);
        int prev = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] - prev <= L) {
                answer--;
            } else {
                prev = arr[i];
            }
        }
        System.out.println(answer);

    }
}
