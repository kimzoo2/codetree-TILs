import java.io.*;
public class Main {
    static int MAX_OFFSET = 1000;
    static int MAX_N = MAX_OFFSET + 100;
    static int[] arr = new int[MAX_N];
    public static void main(String[] args) throws IOException {
        // 질의 개수를 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 이전 구간 위치를 기억할 변수를 선언한다.
        int idx = MAX_OFFSET;

        // 명령만큼 반복한다.
        for(int i = 0; i<n; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            int x1 = Integer.parseInt(s[0]);
            String x2 = s[1];
            idx = fillSection(x1, x2, idx);
        }

        // 2번 이상 지나간 구간을 카운트할 변수를 선언한다.
        int cnt = 0;

        // 구간을 담을 배열만큼 반복한다.
        for (int i = 0; i < MAX_N; i++) {
            // 2번 이상 지나간 구간을 카운트 한다.
            if(arr[i] >= 2) cnt++;
        }
        System.out.println(cnt);
    }

    private static int fillSection(int x1, String x2, int originIdx){
        int temp = originIdx;
        int breakNum = x2.equals("R") ? originIdx+x1 : originIdx-x1;
        while(true) {
            arr[temp]++;
            if (x2.charAt(0) == 'R') {
                temp++; // 오른쪽으로 x1만큼 이동한다.
            } else {
                temp--; // 왼쪽으로 x1만큼 이동한다.
            }
            if (temp == breakNum) {
                return temp; // 이전 구간 위치를 저장한다.
            }
        }
    }
}