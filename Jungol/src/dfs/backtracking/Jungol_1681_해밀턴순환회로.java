package dfs.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jungol_1681_해밀턴순환회로 {
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int N;
	static int min;
	static int[][] adjMatrix;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		stk = new StringTokenizer(in.readLine());
		N = Integer.parseInt(stk.nextToken());
		adjMatrix=new int[N+1][N+1];
		for(int y=1; y<N+1; y++) {
			stk = new StringTokenizer(in.readLine());
			for(int x=1; x<N+1; x++) {
				adjMatrix[y][x]=Integer.parseInt(stk.nextToken());
			}
		}
		min=Integer.MAX_VALUE;
		visited = new boolean[N+1];
		dfs(1,0,0);
		if(min==Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
		in.close();
		out.close();
	}
	private static void dfs(int y, int cnt, int x) {
		if(x==N-1) {
			if(adjMatrix[y][1]!=0) {
				cnt+=adjMatrix[y][1];
				min=Math.min(cnt, min);
				cnt-=adjMatrix[y][1];
			}
			return;
		}
		if(y!=1) visited[y]=true;
		for(int i=2; i<N+1; i++) {
			if(!visited[i] && adjMatrix[y][i]!=0) {
				if(min<=cnt+adjMatrix[y][i]) continue;
				dfs(i,cnt+adjMatrix[y][i],x+1);
				visited[i]=false;
			}
		}
	}
}
