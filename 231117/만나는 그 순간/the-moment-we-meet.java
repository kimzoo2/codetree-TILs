import java.io.*;
public class Main {
    static int MAX_N = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // A가 움직인 횟수
        int m = Integer.parseInt(split[1]); // B가 움직인 횟수

        int curIdx = 0;

        int[] aDistanceArr = new int[MAX_N];
        int[] bDistanceArr = new int[MAX_N];
        int totalSecond = 0;

        // A와 B의 이동을 계산해서 각 배열에 넣는다.
        for (int i = 0; i < n; i++) {
            String[] inputArr = br.readLine().split(" ");
            char direction = inputArr[0].charAt(0);
            int distance = Integer.parseInt(inputArr[1]);
            if(direction == 'R'){ // 오른쪽
                int x1 = curIdx;
                int x2 = curIdx + distance;
                for (int j = x1; j < x2; j++) {
                    aDistanceArr[totalSecond++] = j;
                }
                curIdx += distance;
            }else{
                int x1 = curIdx - distance;
                int x2 = curIdx;
                for (int j = x2; j > x1; j--) {
                    aDistanceArr[totalSecond++] = j;
                }
                curIdx -= distance;
            }
        }

        totalSecond = 0;
        curIdx = 0;

        for (int i = 0; i < m; i++) {
            String[] inputArr = br.readLine().split(" ");
            char direction = inputArr[0].charAt(0);
            int distance = Integer.parseInt(inputArr[1]);
            if(direction == 'R'){ // 오른쪽
                int x1 = curIdx;
                int x2 = curIdx + distance;
                for (int j = x1; j < x2; j++) {
                    bDistanceArr[totalSecond++] = j;
                }
                curIdx += distance;
            }else{
                int x1 = curIdx - distance;
                int x2 = curIdx;
                for (int j = x2; j > x1; j--) {
                    bDistanceArr[totalSecond++] = j;
                }
                curIdx -= distance;
            }
        }


        // 만남 여부 확인 변수
        boolean meetingStatus = false;
        int result = 0;

        // A와 B의 만남 여부를 확인한다.
        for (int i = 1; i < totalSecond; i++) {
            if (aDistanceArr[i] == bDistanceArr[i]) {
                meetingStatus = true;
                result = i;
                break;
            }
        }

        // 만약 만나지 않으면 -1을 출력한다.
        System.out.println(meetingStatus ? result : -1);
    }
}