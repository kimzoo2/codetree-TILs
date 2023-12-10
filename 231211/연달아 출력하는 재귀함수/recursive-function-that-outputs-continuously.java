import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        divide(n);
    }

    private static void divide(int n) {
        if(n < 3){
            System.out.print(n);
            return;
        }else{
            divide(n/3);
            System.out.print(" "+ n);
        }
    }
}