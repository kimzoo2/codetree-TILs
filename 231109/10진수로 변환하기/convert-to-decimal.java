import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();
        int len = binary.length();
        int decimal = 0;

        for(int i = 0; i<len; i++){
            decimal = decimal * 2 + (binary.charAt(i) - '0');
        }

        System.out.println(decimal);
    }
}