package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Jungol_1828_냉장고 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer stk;
	static int N;
	static int[][] chemical;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		chemical = new int[N][2];
		int count = 1;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(in.readLine());
			chemical[i][0] = Integer.parseInt(stk.nextToken());
			chemical[i][1] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(chemical, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int max_Degree = chemical[0][1];
		for(int i=0; i<N; i++) {
			if(chemical[i][0]<=max_Degree) {
				if(chemical[i][1]<max_Degree) {
					max_Degree = chemical[i][1];
				}
				continue;
			}
			else {
				max_Degree=chemical[i][1];
				count++;
			}
		}
		out.append(count+"");
		in.close();
		out.flush();
		out.close();
	}
}
