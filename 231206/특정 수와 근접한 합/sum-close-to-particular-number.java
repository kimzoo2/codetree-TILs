import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int min = Integer.MAX_VALUE;
        int arrSum = 0;

        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = arrSum - arr[i] - arr[j];
                min = Math.min(min, Math.abs(k-sum));
            }
        }

        System.out.println(min);
    }
}