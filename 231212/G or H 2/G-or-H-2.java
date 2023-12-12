import java.io.*;
public class Main {
    static int MAX_LEN2 = 100;
    public static void main(String[] args) throws IOException {

        //N명의 사람들이 일직선상에서 본인들에게 주어진 번호에 해당하는 위치에 서서 G와 H중 받은 알파벳의 팻말을 들고있습니다.
        //오로지 G 혹은 H로만 이루어져 있거나, G와 H가 정확히 같은 개수만큼 나오게 사진을 찍고싶을 때, 최대 사진의 크기를 찾는 프로그램을 작성해보세요.
        //이때, 사진의 크기란 사진에서 양쪽 끝에 있는 사람 간의 거리로 정의되며, 사람이 1명 뿐인 경우에는 사진의 크기가 0입니다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = new char [MAX_LEN2+1];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int idx = Integer.parseInt(split[0]);
            char ch = split[1].charAt(0);
            arr[idx] = ch;
        }
        int max = 0;
        for (int i = 1; i <= MAX_LEN2; i++) {
            int gCnt = 0;
            int hCnt = 0;
            for (int j = i; j <= MAX_LEN2; j++) {
                if(arr[i] == '\u0000' || arr[j] == '\u0000') continue;
                if(arr[j] == 'G') gCnt++;
                else if(arr[j] == 'H') hCnt++;

                if(gCnt==hCnt) {
                    max= Math.max(max, j-i);
                }
            }
        }

        System.out.println(max);
    }
}