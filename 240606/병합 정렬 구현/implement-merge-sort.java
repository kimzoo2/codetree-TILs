import java.io.*;

public class Main {
	static int MAX_LEN = 100_000;
	static int[] temp = new int[MAX_LEN + 1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] split = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		mergeSort(arr, 0, n-1);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void mergeSort(int[] arr, int low, int high){
		if(low < high){
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}

	public static void merge(int[] arr, int low, int mid, int high){
		int i = low, j = mid + 1;
		int k = low;

		while(i <= mid && j <= high){
			if(arr[i] < arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}

		while(i <= mid)
			temp[k++] = arr[i++];

		while(j <= high)
			temp[k++] = arr[j++];

		for (int l = low; l < k; l++) {
			arr[l] = temp[l];
		}
	}
}