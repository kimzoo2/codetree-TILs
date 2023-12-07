import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                int sum = 0;
                for (int k = j; k < j+i; k++) {
                    sum+= arr[k];
                }
                int avg = sum/i;

                // 평균값이 구간의 값 중 하나가 되면 카운트를 증가한다.
                for (int k = j; k < j+i; k++) {
                    if(avg == arr[k]){
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}