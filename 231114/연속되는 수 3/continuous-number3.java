import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        // 입력값 넣기
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int n = 1, ans = 1;
        for (int i = 1; i < cnt; i++) {
            if (arr[i - 1] * arr[i] > 0) {
                n++;
            } else {
                n=1;
            }
            ans = Math.max(ans, n);
        }

        System.out.println(ans);
    }
}