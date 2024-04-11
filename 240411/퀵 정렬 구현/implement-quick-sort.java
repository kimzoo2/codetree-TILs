import java.io.*;
public class Main {
    public static final int MAX_N = 100000;
	public static int n;
	public static int[] arr = new int[MAX_N];
    public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		quickSort(0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
    public static int partition(int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for(int j = low; j < high; j++)
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static void quickSort(int low, int high) {
		if(low < high) {
			int pos = partition(low, high);

			quickSort(low, pos - 1);
			quickSort(pos + 1, high);
		}
	}
}