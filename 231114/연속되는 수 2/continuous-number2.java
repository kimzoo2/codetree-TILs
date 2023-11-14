import java.io.*;
public class Main {
    static int MAX_N = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        // 입력값 넣기
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] cntArr = new int[MAX_N+1];
        int n = 1;
        // input 숫자가 최대 몇 개 입력되었는지
        // cnt 배열로 정리하기
        for (int i = 1; i < cnt; i++) {
            if(arr[i-1] == arr[i]) n++;
            else{
                cntArr[arr[i-1]] = Math.max(cntArr[arr[i-1]], n);
                n = 1;
            }
        }
        cntArr[arr[cnt-1]] = Math.max(cntArr[arr[cnt-1]], n); // 마지막 값 세팅

        // 수열 중 가장 많이 카운트 된 수 넣기
        int max = 0;
        for (int i = 0; i <= MAX_N; i++) {
            if(cntArr[i] > max) max = cntArr[i];
        }
        System.out.println(max);
    }
}