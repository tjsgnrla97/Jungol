package koi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jungol_2577_회전초밥_고 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int N,D,K,C,ans;
	static int[] eattingList, isSelected;
	public static void main(String[] args) throws IOException {
		stk = new StringTokenizer(in.readLine());
		N = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		isSelected = new int[D+1];
		eattingList = new int[N+K];
		for(int n=0; n<N; n++) eattingList[n]=Integer.parseInt(in.readLine());
		for(int n=N; n<N+K; n++) eattingList[n]=eattingList[n-N];
		ans = -1;
		eat();
		out.write(ans+"");
		out.flush();
		out.close();
		in.close();
	}
	private static void eat() {
		int cnt=0;
		int coupon=0;
		for(int n=0; n<N+K; n++) {
			if(n>=K) {
				if(--isSelected[eattingList[n-K]]==0) cnt--;
				if(eattingList[n-K]==C) coupon--;
			}
			if(++isSelected[eattingList[n]]==1) cnt++;
			if(eattingList[n]==C) coupon++;
			if(n>=K) ans = Math.max(ans, coupon==0?cnt+1:cnt);
		}
	}
}
