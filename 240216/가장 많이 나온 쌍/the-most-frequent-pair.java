import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		int n = Integer.parseInt(size[0]);
		int m = Integer.parseInt(size[1]);
		int[] a = new int[m];
		int[] b = new int[m];

		for (int i = 0; i < m; i++) {
			String[] inputs = br.readLine().split(" ");
			a[i] = Integer.parseInt(inputs[0]);
			b[i] = Integer.parseInt(inputs[1]);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			int cnt = 1;
			for (int j = i+1; j < m; j++) {
				if((a[i] == a[j] && b[i] == b[j]) ||
					(a[i] == b[j] && b[i] == a[j])
				) cnt++;
			}
			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}
}