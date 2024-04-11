import java.io.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] split = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		quickSort(arr, 0, N-1);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int partition(int[] arr, int low, int high){
		int i = low -1; // blue
		int pivot = getPivot(arr, low, high);

		for (int j = low; j <= high; j++) {
			if(arr[j] < pivot){
				i++;
				if(arr[j] < arr[i]){
					swapValue(arr, i, j);
				}
			}
		}
		if(arr[i + 1] > arr[high]) {
			swapValue(arr, i + 1, high);
		}
		return i + 1;
	}

	private static int getPivot(int[] arr, int low, int high) {
		if(high - low <= 3){
			return high;
		}
		int pivot = getMid(arr, low, high);
		swapValue(arr, pivot, high);
		return arr[high];
	}

	private static void swapValue(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int getMid(int[] arr, int low, int high){
		int mid = N/2;
		if(arr[low] > arr[mid]){
			if(arr[low] < arr[high]) return low;
		}else if(arr[mid] > arr[low]){
			if(arr[mid] < arr[high]) return mid;
		}
		return high;
	}

	private static void quickSort(int[] arr, int low, int high){
		int pos;
		if(low < high){
			pos = partition(arr, low, high);

			quickSort(arr, low ,pos-1);
			quickSort(arr, pos + 1, high);
		}
	}
}