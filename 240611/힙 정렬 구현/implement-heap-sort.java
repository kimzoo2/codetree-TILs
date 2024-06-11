import java.io.*;
public class Main {

    private static void swap(int[] arr, int x, int y){
		// swap
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void heapify(int[] arr, int n, int i){
		int largest = i;
		int l = 2 * i;
		int r = 2 * i + 1;

		if (l <= n && arr[l] > arr[largest])
			largest = l;

		if (r <= n && arr[r] > arr[largest])
			largest = r;

		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
		}
	}

	public static void heapSort(int[] arr, int n){
		// max heap 만들기
		for (int i = n / 2; i > 0; i--) {
			heapify(arr, n, i);
		}

		// 정렬한다
		for (int i = n; i > 1; i--) {
			swap(arr, 1, i);
			heapify(arr, i-1, 1);
		}
	}
    public static void main(String[] args)  throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(split[i-1]);
		}

		heapSort(arr, n);

		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
    }
}