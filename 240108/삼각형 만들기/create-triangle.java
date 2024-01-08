import java.io.*;
public class Main {
    static int CNT = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CNT = Integer.parseInt(br.readLine());
        int[][] arr = new int[CNT][2];

        for (int i = 0; i < CNT; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]); // x
            arr[i][1] = Integer.parseInt(split[1]); // y
        }

        int maxArea = 0;

        // 세 점만 얻기
        for (int i = 0; i < CNT; i++) {
            for (int j = i+1; j < CNT; j++) {
                for (int k = j+1; k < CNT; k++) {
                    maxArea = Math.max(maxArea, getMaxArea(i, j, k, arr));
                }
            }
        }

        System.out.println(maxArea * 2);
    }

    private static int getMaxArea(int i1, int i2, int i3, int[][] arr){
        int area = 0;
        // x가 평행한가?
        if(arr[i1][0] == arr[i2][0] || arr[i2][0] == arr[i3][0] ||arr[i1][0] == arr[i3][0]){
            // y가 평행한가?
            if(arr[i1][1] == arr[i2][1] || arr[i2][1] == arr[i3][1] ||arr[i1][1] == arr[i3][1]){
                //
                int a = (arr[i1][0] * arr[i2][1] + arr[i2][0] * arr[i3][1] + arr[i3][0]*arr[i1][1]);
                int b = (arr[i2][0] * arr[i1][0] + arr[i3][0] * arr[i2][1] + arr[i1][0]*arr[i3][1]);
                area = (a-b) / 2;
            }
        }
        return area;
    }
}