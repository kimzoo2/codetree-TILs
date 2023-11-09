import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = toBinary(str);
        System.out.println(toDecimal(result));
    }

    private static int toBinary(String binary){
        int num = 0;
        int len = binary.length();

        for(int i = 0; i<len; i++){
            num = num * 2 + (binary.charAt(i) - '0');
        }

        return num * 17;
    }

    private static StringBuilder toDecimal(int decimal){
        StringBuilder sb = new StringBuilder();
        while(true){
            if(decimal < 2){
                sb.append(decimal);
                break;
            }
            sb.append(decimal % 2);
            decimal /= 2;
        }
        return sb.reverse();
    }
}