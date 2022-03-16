import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if (cmd == 'P') {
                left.push(st.nextToken().charAt(0));
            } else if (cmd == 'D') {
                if (!right.isEmpty())
                    left.push(right.pop());
            } else if (cmd == 'L') {
                if (!left.isEmpty())
                    right.push(left.pop());
            } else {
                if (!left.isEmpty())
                    left.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : left) {
            sb.append(character);
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
