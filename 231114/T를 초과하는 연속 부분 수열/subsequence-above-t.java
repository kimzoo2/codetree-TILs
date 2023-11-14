import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 정수 T가 주어졌을 때, t보다 큰 수로만 이루어진 연속 부분 수열을 찾아라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int t = Integer.parseInt(split[1]);
        int[] arr = new int[n];
        String[] split1 = br.readLine().split(" ");
        // 입력값 넣기
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split1[i]);
        }
        int cnt = 0, ans = 1;
        for (int i = 0; i < n; i++) {
            if(arr[i] > t) cnt++;
            else cnt = 0;

            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}