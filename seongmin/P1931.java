import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] m = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(m, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });
        int answer = 1;
        int end = m[0].end;
        for (int i = 1; i < N; i++) {
            if (end <= m[i].start) {
                answer++;
                end = m[i].end;
            }
        }
        System.out.println(answer);
    }

    static class Meeting {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
