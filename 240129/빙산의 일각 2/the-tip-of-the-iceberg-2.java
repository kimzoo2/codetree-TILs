import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

		// 해수면의 높이에 따라 물에 잠기는 빙산들이 있습니다.
		// 빙산의 개수 N이 주어지고 N개의 빙산들의 높이 H(i)가 순서대로 주어집니다.
		// 빙산들이 물에 잠기지 않은 채로 붙어있는 경우를 한 덩어리로 볼 때, 해수면의 높이를 적절하게 설정 했을 때 가능한 빙산 덩어리의 최대 개수를 구하는 프로그램을 아래 예를 참고하여 작성해보세요.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] iceBergs = new int[cnt+1];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= cnt; i++) {
			iceBergs[i] = Integer.parseInt(br.readLine());
			min = Math.min(min, iceBergs[i]);
			max = Math.max(max, iceBergs[i]);
		}

		int ans = Integer.MIN_VALUE;
		int[] temp = new int[cnt+1];
		for (int i = min; i <= max; i++) {
			int tipCnt = 0;
			for (int j = 0; j <= cnt; j++) {
				temp[j] = iceBergs[j]-i;
			}
			for (int j = 1; j <= cnt; j++) {
				if(temp[j-1] <= 0 && temp[j] > 0) tipCnt++;
			}
			ans = Math.max(ans, tipCnt);
		}
		System.out.println(ans);
	}
}