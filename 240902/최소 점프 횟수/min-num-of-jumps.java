import java.io.*;
import java.util.*;

public class Main {

    private static int minJumpCnt = Integer.MAX_VALUE;
	private static int n;

    private static void getMinJumpCount(int[] jumpCountArr, int cnt, int jumpCnt) {
		if(cnt == n - 1){
			minJumpCnt = Math.min(minJumpCnt, jumpCnt);
			return;
		}
		for (int i = 1; i <= jumpCountArr[cnt]; i++) {
			getMinJumpCount(jumpCountArr, cnt + i, jumpCnt + 1);
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String jumpCount = br.readLine();
		String[] split = jumpCount.split(" ");
		int[] jumpCountArr = new int[n];
		for (int i = 0; i < n; i++) {
			jumpCountArr[i] = Integer.parseInt(split[i]);
		}

		getMinJumpCount(jumpCountArr, 0, 0);

		System.out.println(minJumpCnt == Integer.MAX_VALUE ? -1 : minJumpCnt);
    }
}