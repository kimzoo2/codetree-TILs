import java.io.*;
public class Main {
    static int MAX = 1000;
    public static void main(String[] args) throws IOException {
		// 데이터센터 안에 있는 장비들의 효율을 위해 온도를 맞춰주려고 합니다.
		// 각 장비들마다 선호하는 온도의 범위들이 전부 다릅니다. 각 장비의 작업량은 다음과 같이 정의됩니다.
		//
		// 만약 데이터센터의 온도범위가 장비 A가 선호하는 온도 Ta 보다 낮다면 C만큼의 작업량을 수행하고, A < Ta = c
		// 만약 데이터센터의 온도범위가 장비 A가 선호하는 온도 Ta이상 Tb 이하에 있다면 G만큼의 작업량을 수행하고, Ta <= A <= Tb = G
		// 만약 데이터센터의 온도범위가 장비 A가 선호하는 온도 Tb 보다 높다면 H만큼의 작업량을 수행합니다. A > Tb = H

		// 장비의 개수 N과 온도에 따른 장비들의 작업량 C, G, H가 주어지고
		// N개 장비들이 선호하는 온도의 범위가 주어지면 온도를 적절히 설정하여 데이터센터안의 최고 작업량을 출력하는 프로그램을 작성해보세요.

		//4 7 9 6
		// 5 8
		// 3 4
		// 13 20
		// 7 10
		// => 31

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		int g = Integer.parseInt(input[2]);
		int h = Integer.parseInt(input[3]);

		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] degrees = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(degrees[0]);
			arr[i][1] = Integer.parseInt(degrees[1]);
		}
		int max = 0;
		for (int i = 0; i <= MAX; i++) {
			int workload = 0;
			for (int j = 0; j < n; j++) {
				if(i < arr[j][0]) workload += c;
				else if(arr[j][0] <= i && i <= arr[j][1]) workload += g;
				else workload += h;
			}
			max = Math.max(max, workload);
		}
		System.out.println(max);
	}
}