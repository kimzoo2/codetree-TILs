import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        int max = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    // i,j, k의 자릿수별 더하기
                    boolean isCarry = false;
                    int sum = 0;
                    int num1 = arr[i];
                    int num2 = arr[j];
                    int num3 = arr[k];
                    while(true){
                        if(isCarry || (num1 == 0 && num2 == 0 && num3 == 0)) break;
                        sum = num1 % 10 + num2 % 10 + num3 % 10;
                        num1 /= 10;
                        num2 /= 10;
                        num3 /= 10;
                        isCarry = (sum >= 10);
                    }
                    if(!isCarry){
                        max = Math.max(max, (arr[i] + arr[j] + arr[k]));
                    }
                }
            }
        }
        System.out.println(max);
    }
}