import java.io.*;
public class Main {
    
    private static int n;

    private static void printList(int[] arr){
		for (int i = 0; i <n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void choose(int cnt, int[] arr, boolean[] checked){
		if(n == cnt){
			printList(arr);
			return;
		}

		for (int i = n; i >= 1; i--) {
			if(checked[i]) continue;
			arr[cnt] = i;
			checked[i] = true;
			choose(cnt + 1, arr, checked);
			checked[i] = false;
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		boolean[] checked = new boolean[n + 1];
		choose(0, new int[n], checked);
	}
}