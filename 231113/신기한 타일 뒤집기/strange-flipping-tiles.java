import java.io.*;
public class Main {
    static int OFFSET_TEMP = 100_000;
    static int MAX_N_TEMP = OFFSET_TEMP * 2 + 1;
    static char[] sectionArr = new char[MAX_N_TEMP];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 회색 타일이 존재함
        // L : 흰색 R : 검은색
        // 타임 포함 총 x칸의 타일을 뒤집음
        // 흰색, 검은색 타일 수를 각각 출력하기
        int cnt = Integer.parseInt(br.readLine());
        int curIdx = OFFSET_TEMP;
        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            String[] split = str.split(" ");
            int x = Integer.parseInt(split[0]);
            char direction = split[1].charAt(0);

            if(direction == 'R'){
                while(x-- > 0){
                    sectionArr[curIdx] = direction;
                    if(x > 0) curIdx++;
                }
            }
            else{
                while (x-- > 0){
                    sectionArr[curIdx] = direction;
                    if(x > 0) curIdx--;
                }
            }
        }
        int whiteSection = 0;
        int blackSection = 0;
        for (int i = 0; i < MAX_N_TEMP; i++) {
            if(sectionArr[i] == 'R') blackSection++;
            else if (sectionArr[i] == 'L') whiteSection++;
        }
        System.out.println(whiteSection + " " +  blackSection);
    }
}