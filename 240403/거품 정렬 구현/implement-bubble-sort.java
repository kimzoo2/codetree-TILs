import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //6
		// 5 2 6 1 3 8
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		boolean flag = false;

		do {
			flag = true;
			for (int i = 0; i < n-1; i++) {
				if(arr[i] > arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					flag = false;
				}
			}

		}while(flag == false);

		for (int i : arr) {
			System.out.print(i + " ");
		}
    }
}