import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        //좌표평면 위에 점 N개가 있습니다.
        //그 N개의 점들 중 정확히 하나의 점만 빼서, 뺀 후의 모든 점들을 포함하는 직사각형의 넓이를 최소로 하는 프로그램을 작성해보세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int minX = Integer.MAX_VALUE;
            int maxX = 0;
            int minY = Integer.MAX_VALUE;
            int maxY = 0;
            for (int j = 0; j < n; j++) { // 위치 찍기
                if(i == j) continue;
                minX = Math.min(minX, arr[j][0]);
                maxX = Math.max(maxX, arr[j][0]);
                minY = Math.min(minY, arr[j][1]);
                maxY = Math.max(maxY, arr[j][1]);
            }
            minArea = Math.min(minArea, ((maxX - minX) * (maxY - minY)));
        }
        System.out.println(minArea);
    }
}