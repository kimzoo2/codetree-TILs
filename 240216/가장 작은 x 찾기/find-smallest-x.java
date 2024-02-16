import java.io.*;
public class Main {
    static int MAXLEN = 10_000;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			a[i] = Integer.parseInt(split[0]);
			b[i] = Integer.parseInt(split[1]);
		}

			//4
		// 1 10
		// 10 16
		// 20 25
		// 40 50
		// =>3
		int ans = 0;
		for (int i = 1; i <= MAXLEN; i++) {
			int x = i;
			boolean IsMinX = true;
			for (int j = 0; j < n; j++) {
				x *= 2;
				if(!(x >= a[j]) || !(x <= b[j])) IsMinX = false;
			}
			if(IsMinX){
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}