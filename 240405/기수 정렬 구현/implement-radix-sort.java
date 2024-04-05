import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
	public static final int MAX_DIGIT = 10;
	public static final int MAX_K = 6;
	public static int n;
	public static int[] arr = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		radixSort();

		for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
	}

	private static void radixSort(){
		int p = 1;
		for(int pos = 0; pos < MAX_K; pos++) {
			ArrayList<Integer>[] arrNew = new ArrayList[MAX_DIGIT];
			// 자릿수에 따른 정렬된 수를 저장할 bucket을 만든다
			for(int i = 0; i < MAX_DIGIT; i++)
				arrNew[i] = new ArrayList<>();

			// bucket에 자릿수에 따라 숫자를 저장한다
			for(int i = 0; i < n; i++) {
				int digit = (arr[i] / p) % 10;
				arrNew[digit].add(arr[i]);
			}

			//
			int index = 0;
			for(int i = 0; i < MAX_DIGIT; i++)
				for(int j = 0; j < arrNew[i].size(); j++)
					// arr에 저장된 순서대로 저장한다
					arr[index++] = arrNew[i].get(j);

			p *= 10;
		}
	}
}