package backjoon.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_1504_특정한최단경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, E, v1, v2;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new StringReader(src));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1;
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, cost));
			graph[to].add(new Node(from, cost));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		long way1 = 0;
		way1 += daik(1, v1);
		way1 += daik(v1, v2);
		way1 += daik(v2, N-1);
		
		long way2 = 0;
		way2 += daik(1, v2);
		way2 += daik(v2, v1);
		way2 += daik(v1, N-1);
		
		long result = Math.min(way1, way2);
		if(result >= Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}

	}
	
	

	static int daik(int start, int end) {
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 출발 번호
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int vertex = node.vertex;
			int weight = node.weight;
			if(distance[vertex] < weight) continue;
			
			for (int i = 0; i < graph[vertex].size(); i++) {
				int v = graph[vertex].get(i).vertex;
				int w = graph[vertex].get(i).weight;
				if(distance[v] > w + weight) {
					distance[v] = w + weight;
					q.add(new Node(v, w + weight));
				}
			}
		}
		
		return distance[end];
	}

	static class Node implements Comparable<Node>{
		int vertex, weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}


	}

	static String src = "4 6\r\n" + "1 2 3\r\n" + "2 3 3\r\n" + "3 4 1\r\n" + "1 3 5\r\n" + "2 4 5\r\n" + "1 4 4\r\n"
			+ "2 3";

}
