import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1431 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                int sumO1 = 0;
                int sumO2 = 0;
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                        sumO1 += o1.charAt(i) - '0';
                    }
                    if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                        sumO2 += o2.charAt(i) - '0';
                    }
                }
                if (sumO1 == sumO2) {
                    return o1.compareTo(o2);
                }
                return sumO1 - sumO2;
            } else {
                return o1.length() - o2.length();
            }
        }));

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
