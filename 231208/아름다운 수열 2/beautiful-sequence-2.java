import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N개의 숫자로 이루어진 수열 A와 M개의 숫자로 이루어진 수열 B가 주어집니다.
        // 수열 B의 각 원소들의 순서를 바꿔 나오는 수열을 아름다운 수열이라고 합니다. 수열 A에서 길이가 M인 연속 부분 수열들 중 아름다운 수열의 수를 세는 프로그램을 작성해보세요.

        // 예를 들어 수열 B를 “4 6 7“이라 했을 때 "4 6 7", "4 7 6", "6 4 7", "6 7 4", "7 4 6", "7 6 4"는 모두 아름다운 수열이 됩니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 수열 A의 크기
        int m = Integer.parseInt(split[1]); // 수열 B의 크기

        int[] aArr = new int[n];
        int[] bArr = new int[m];

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(a[i]);
        }
        for (int i = 0; i < m; i++) {
            bArr[i] = Integer.parseInt(b[i]);
        }

        // B 수열의 숫자가 존재하면서 연속해야 함.
        boolean isCorrect = false;
        int cnt = 0;

        for (int i = 0; i <= n - m; i++) {
            isCorrect = false;
            for (int j = i; j < i+m; j++) {
                for (int k = 0; k < m; k++) {
                    // A 수열의 숫자가 B 수열에 존재하면 true로 변경한다.
                    if(aArr[j] == bArr[k]) {
                        isCorrect = true;
                        break;
                    }
                    isCorrect = false;
                }
                // A 수열의 숫자가 B 수열에 존재하지 않으면 끝낸다.
                if(isCorrect == false) break;
            }
            // A 수열의 숫자가 B 수열에 모두 존재하면 카운트를 증가 시킨다.
            if(isCorrect == true) cnt++;
        }

        System.out.println(cnt);
    }
}