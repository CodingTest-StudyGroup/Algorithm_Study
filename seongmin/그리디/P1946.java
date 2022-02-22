import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Applicant[] arr = new Applicant[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = new Applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(arr, ((o1, o2) -> {
                return o1.doc - o2.doc;
            }));
            int before = arr[0].itv;
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (before > arr[i].itv) {
                    count++;
                    before = arr[i].itv;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    static class Applicant {
        int doc, itv;

        public Applicant(int doc, int itv) {
            this.doc = doc;
            this.itv = itv;
        }
    }
}
