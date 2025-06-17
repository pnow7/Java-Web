package test.test06.test0617;

/*
- 연속합

n개의 정수로 이루어진 임의의 수열이 주어진다. 
우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 

단, 수는 한 개 이상 선택해야 한다.
예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 
여기서 정답은 12+21인 33이 정답이 된다.

-입력
첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

-출력
첫째 줄에 답을 출력한다.

[입력]
10
10 -4 3 1 5 6 -35 12 21 -1

[출력]
33

[입력]
10
2 1 -4 3 4 -4 6 5 -5 1

[출력]
14

[입력]
5
-1 -2 -3 -4 -5

[출력]
-1

*/

import java.io.*;
import java.util.*;

public class FMain1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * int[] dp = new int[n]; 
		 * dp[0] = arr[0]; 
		 * int max = dp[0];
		 * 
		 * for(int i = 1; i < n; i++) { 
		 * 	   dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
		 * 	   max = Math.max(max, dp[i]); 
		 * }
		 */
		
		int sum = arr[0];
		int max = arr[0];
				
		for(int i = 1; i < n; i++) {
			sum = Math.max(arr[i],  sum + arr[i]);
			max = Math.max(max,  sum);
		}
		
		System.out.println(max);
		
		br.close();
	}
	
}
