import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_S2_2210_숫자판점프 {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static String[][] map;
	public static int dx[] = { -1, 1, 0, 0 };
	public static int dy[] = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
	private static HashSet<String> nums = new HashSet<>(); // 중복방지 

	public static void main(String[] args) throws IOException {
		
		map = new String[5][5];
		for (int r = 0; r < 5; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < 5; c++) {
				map[r][c] = tokens.nextToken();
			}
		}
		// 입력 완료! 

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				dfs(r, c, 0, map[r][c]);
			}
		}
		
		System.out.println(nums.size());

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < 5 && c < 5;
	}

	public static void dfs(int r, int c, int cnt, String num) {
		if (cnt == 5) {
			nums.add(num);
//			System.out.println(num);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];

			if (!isIn(nr, nc))
				continue;
			dfs(nr, nc, cnt + 1, num + map[nr][nc]);
		}

	}

}
