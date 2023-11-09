import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            if(num < 2){
                sb.append(num);
                break;
            }
            sb.append(num % 2);
            num /= 2;
        }

        System.out.println(sb.reverse());
    }
}