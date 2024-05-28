import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] split = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		for (int i = 1; i < n; i++) {
			int j = i-1;
			int key = arr[i];
			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
    }
}