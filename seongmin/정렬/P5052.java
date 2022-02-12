import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);
            String number = arr[0];
            boolean check = false;
            for (int i = 1; i < n; i++) {
                if (arr[i].startsWith(number)) {
                    sb.append("NO").append('\n');
                    check = true;
                    break;
                }
                number = arr[i];
            }
            if (!check) {
                sb.append("YES").append('\n');
            }
        }
        System.out.print(sb);
    }
}
