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
            if(ch == '0'){
                ch = '1';
            }else{
                ch = '0';
            }
            if(i > 0) {
                tempStr = str.substring(0, i) + ch + str.substring(i+1);
            }else{
                tempStr = ch + str.substring(i+1);
            }
            max = Math.max(max, Integer.valueOf(tempStr, 2));
        }

        System.out.println(max);
    }
}