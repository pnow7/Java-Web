package test.test05.test0521;

/*

[입력]
3 1

[출력]
1
2
3

[입력]
4 2

[출력]
1 2
1 3
1 4
2 3
2 4
3 4

[입력]
4 4

[출력]
1 2 3 4
*/

import java.io.*;
import java.util.*;

public class FMain15650 {
	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
				;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(1, 0);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	public static void dfs(int at, int depth) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i+1, depth+1);
		}
	}
}

/*

깊이를 의미하는 depth 변수뿐만 아니라 at 변수를 추가

at 변수의 의미는 현재 위치, 즉 어디서부터 시작하는지를 의미하는 변수다. 

예로들어 반복문에서 재귀를 해 줄 때, 
at = 1 부터 시작하면 다음 재귀는 오름차순으로 탐색하기 위해 at 을 1 증가시킨 2를 인자로 넘겨주면서 
다음 재귀의 반복문이 2부터 시작하도록 하는 변수를 의미한다.
 
*/