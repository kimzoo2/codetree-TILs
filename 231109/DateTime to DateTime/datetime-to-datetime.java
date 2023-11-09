import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] s = str.split(" ");
        int day = Integer.parseInt(s[0]);
        int hour = Integer.parseInt(s[1]);
        int min = Integer.parseInt(s[2]);

        System.out.println(calculateDate(day,hour, min) - calculateDate(11,11,11));
    }

    public static int calculateDate(int d, int h, int m){
        return (d * 24 * 60) + (h * 60) + m;
    }
}