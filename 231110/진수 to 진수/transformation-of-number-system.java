import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] s = str.split(" ");
        int originNumber = Integer.parseInt(s[0]);
        int changeNumber = Integer.parseInt(s[1]);
        String targetNumber = br.readLine();
        int result = 0 ;

        result = toDecimal(originNumber, targetNumber); // origin진수에서 10진수로 변환한다.
        System.out.println(toChangeNumber(changeNumber, result)); // 10진수에서 change진수로 변경한다.
    }

    public static int toDecimal(int originNumber, String targetNumber){
        int result = 0;
        int len = targetNumber.length();

        for (int i = 0; i < len; i++) {
            result = i * originNumber + (targetNumber.charAt(i) -'0');
        }
        return result;
    }

    public static StringBuilder toChangeNumber(int changeNumber, int targetNumber){
        StringBuilder sb = new StringBuilder();
        while(true){
            if(targetNumber < changeNumber){
                sb.append(targetNumber);
                break;
            }
            sb.append(targetNumber % changeNumber);
            targetNumber /= changeNumber;
        }
        return sb.reverse();
    }
}