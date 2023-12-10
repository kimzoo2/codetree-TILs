import java.io.*;
public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int sum = 0;
        int min = b;
        for (int i = a; i <= b; i++) {
            if(isPrime(i)){
                min = Math.min(min, i);
                sum += i;
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(min);
        }
    }

    private static boolean isPrime(int n){
        if(n == 1) return false;
        for (int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}