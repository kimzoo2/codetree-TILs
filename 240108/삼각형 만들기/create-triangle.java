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

        System.out.println(maxArea);
    }

    private static int getMaxArea(int i1, int i2, int i3, int[][] arr){
        int area = 0;
        int x1 = arr[i1][0], x2 = arr[i2][0], x3 = arr[i3][0];
        int y1 = arr[i1][1], y2 = arr[i2][1], y3 = arr[i3][1];
        // x가 평행한가?
        if(x1 == x2 || x2 == x3 || x1 == x3){
            // y가 평행한가?
            if(y1 == y2 || y2 == y3 ||y1 == y3){
                //
                int a = (x1 * y2 + x2 * y3 + x3 * y1);
                int b = (x2 * y1 + x3 * y2 + x1 * y3);
                area = (a-b);
            }
        }
        return area;
    }
}