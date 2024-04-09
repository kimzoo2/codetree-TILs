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

		mergeSort(arr, 0, n-1);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void mergeSort(int[] arr, int low, int high){
		if(low < high){
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid); // 왼쪽을 정렬한다.
			mergeSort(arr, mid+1, high); // 오른쪽을 정렬한다.
			merge(arr, low, mid, high); // 정렬한 값을 합친다.
		}
	}

	public static void merge(int[] arr, int low, int mid, int high){
		int[] temp = new int[arr.length];

		int i = low; // 왼쪽 기준
		int j = mid + 1; // 가운데 기준
		int k = low; // 시작점

		while(i <= mid && j <= high){
			if(arr[i] < arr[j]){
				temp[k] = arr[i];
				k++; i++;
			}else{
				temp[k] = arr[j];
				k++; j++;
			}
		}

		while(i <= mid){
			temp[k] = arr[i];
			k++; i++;
		}

		while(j <= high){
			temp[k] = arr[j];
			k++; j++;
		}

		for (int l = low; l <= high; l++) {
			arr[l] = temp[l];
		}
	}
}