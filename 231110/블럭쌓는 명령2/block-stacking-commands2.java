import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] s = input.split(" ");
        int n = Integer.parseInt(s[0]); // 칸의 수
        int k = Integer.parseInt(s[1]); // 명령의 수
        int[] arr = new int[n];
        int firstOrder = 0;
        int secondOrder = 0;

        for(int i = 0 ; i<k; i++){
            String order = br.readLine();
            String[] orderList = order.split(" ");
            firstOrder = Integer.parseInt(orderList[0])-1;
            secondOrder = Integer.parseInt(orderList[1])-1;

            for(int j = firstOrder; j<=secondOrder; j++){
                arr[j] = ++arr[j];
            }
        }

        int idx = 0;
        for(int i = 1; i<n; i++){
            if(arr[idx] < arr[i]){
                idx = i;
            }
        }

        System.out.println(arr[idx]);
    }
}