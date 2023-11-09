import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split(" ");
        int num = Integer.parseInt(split[0]); // origin 값
        int x = Integer.parseInt(split[1]); // 4 or 8 진수
        StringBuilder castingNum = new StringBuilder();

        while(true){
            if(num < x){
                castingNum.append(num);
                break;
            }
            castingNum.append(num % x);
            num /= x;
        }

        System.out.println(castingNum.reverse());
    }
}