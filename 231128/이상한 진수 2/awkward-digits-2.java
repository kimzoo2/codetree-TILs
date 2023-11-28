import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();

        int max = 0;
        for (int i = 0; i < len; i++) {
            String tempStr = str;
            char ch = str.charAt(i);
            tempStr = str.substring(0, i) + (char)((int)'0' + '1' - ch) + str.substring(i+1);
            max = Math.max(max, Integer.valueOf(tempStr, 2));
        }

        System.out.println(max);
    }
}