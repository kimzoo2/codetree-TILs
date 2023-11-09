import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] s = str.split(" ");
        int m1Month = Integer.parseInt(s[0]);
        int m1Day = Integer.parseInt(s[1]);
        int m2Month = Integer.parseInt(s[2]);
        int m2Day = Integer.parseInt(s[3]);
        String day = br.readLine();

        // 차이나는 요일 구하기
        int calculateDay = (numOfDays(m2Month, m2Day) - numOfDays(m1Month, m1Day));

        System.out.println(calculateRepeatDayCount(calculateDay, day));

    }

    private static int calculateRepeatDayCount(int d, String day){
        int dayCnt = 0;
        String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for(int i = 0; i<=d; i++){
            if(days[i%7].equals(day)) dayCnt++;
        }
        return dayCnt;
    }

    private static int numOfDays(int m, int d){
        int[] days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        for(int i = 0; i<m; i++){
            totalDays += days[i];
        }
        totalDays += d;
        return totalDays;
    }
}