import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(str.charAt(i) == '(' && str.charAt(j) == ')') cnt++;
            }
        }
        System.out.println(cnt);
    }
}