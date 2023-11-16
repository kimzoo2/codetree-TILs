import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        System.out.println(power(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
    }

    private static int power(int target, int cnt){
        if(cnt == 0){
            return 1;
        }else{
            target *= power(target, --cnt);
        }
        return target;
    }
}