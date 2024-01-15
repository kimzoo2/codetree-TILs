import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        //4
        // -3 4
        // 7 8
        // 10 16
        // 3 9
        // 대각선으로 다른 선분과 겹치지 않는 선분을 찾아라.
        // 답 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] stdArr = new int[cnt+1];
        int[] endArr = new int[cnt+1];
        for (int i = 0; i < cnt; i++) {
            String[] split = br.readLine().split(" ");
            stdArr[i] = Integer.parseInt(split[0]);
            endArr[i] = Integer.parseInt(split[1]);
        }

        int ans = 0;
        boolean overlap = true;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                if(i == j) continue;
				if ((stdArr[i] < stdArr[j] && endArr[i] > endArr[j]) || stdArr[i] > stdArr[j] && endArr[i] < endArr[j]) {
					overlap = false;
					break;
				}
                overlap = true;
            }
            if(overlap) ans++;
        }

        System.out.println(ans);
    }
}