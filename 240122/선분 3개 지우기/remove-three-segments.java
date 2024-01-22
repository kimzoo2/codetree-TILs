import java.io.*;
public class Main {
    static int MAX_LEN =10;
    static int[][] points = new int[MAX_LEN][2];
    public static void main(String[] args) throws IOException {
        //1차원 직선 상에 n개의 선분이 주어집니다.
        // 이 중 서로 다른 선분 3개를 제거하여 남은 n - 3개의 선분끼리 모두 겹쳐지지 않도록 하는 서로 다른 가짓수를 구하는 출력하는 프로그램을 작성해보세요.
        // 단, 두 선분끼리 경계에서 닿는 경우 역시 겹치는 것으로 생각합니다.

        //5
        // 1 3
        // 2 4
        // 3 5
        // 6 8
        // 7 9

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String[] point = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(point[0]);
            points[i][1] = Integer.parseInt(point[1]);
        }
        int ans = 0;

        for (int i = 0; i < cnt; i++) {
            for (int j = i+1; j < cnt; j++) {
                for (int k = j+1; k < cnt; k++) {
                    if(hasNoOverlapLine(i, j, k, cnt)) ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean hasNoOverlapLine(int i, int j, int k, int cnt){
        int maxLen = 100;
        int[] line = new int[maxLen+1];
        // 3개의 선분을 제외하고 line을 그린다.
        for (int l = 0; l < cnt; l++) {
            if(l == i || l == j || l == k) continue;
            for (int m = points[l][0]; m <= points[l][1]; m++) {
                line[m]++;
            }
        }
        // 겹친 line이 있으면 false로 return한다.
        for (int l = 0; l <= maxLen; l++) {
            if(line[l] > 1) return false;
        }
        return true;
    }
}