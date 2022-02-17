import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_1012_유기농배추 {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output = new StringBuilder();
	private static StringTokenizer tokens;

	private static int T; // 테캐 수
	private static int M, N, K; // 배추밭 가로길이, 세로길이, 배추 위치 개수
	private static int[][] field;
	private static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());

			field = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				tokens = new StringTokenizer(input.readLine());
				int y = Integer.parseInt(tokens.nextToken());
				int x = Integer.parseInt(tokens.nextToken());
				field[x][y] = 1;
			}
			// 입력완료
			
			answer = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(dfs(r, c)) {
						answer++;
					}
				}
			}

			output.append(answer + "\n");
		}
		System.out.println(output);
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	// 특정 노드 방문하고 연결된 모든 노드들도 방문!
	public static boolean dfs(int r, int c) {
		
		if(!isIn(r, c)) return false;

		// 현재 노드를 아직 방문하지 않았으면
		if(field[r][c] == 1) {
			// 해당 노드 방문 처리
			field[r][c] = 0;
			// 상, 하, 좌, 우의  위치들도 모두 재귀호출
			dfs(r-1, c);
			dfs(r, c-1);
			dfs(r+1, c);
			dfs(r, c+1);
			return true;
		}
		return false;

	}

}
