import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] s = str.split(" ");
        int m1Month = Integer.parseInt(s[0]);
        int m1Day = Integer.parseInt(s[1]);
        int m2Month = Integer.parseInt(s[2]);
        int m2Day = Integer.parseInt(s[3]);

        // 차이 나는 일자를 구하고
        int calculateDay = (numOfDays(m2Month, m2Day) - numOfDays(m1Month, m1Day)) % 7;
        // 요일을 구하기
        String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        System.out.println(days[calculateDay < 0 ? calculateDay+7 : calculateDay]);
    }

    private static int numOfDays(int m, int d){
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for(int i = 0; i<m; i++){
            totalDays += days[i];
        }
        totalDays += d;
        return totalDays;
    }
}