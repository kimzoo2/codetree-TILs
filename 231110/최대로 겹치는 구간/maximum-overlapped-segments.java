import java.io.*;

public class Main {
    static int MAX_LINE = 200;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lineArr = new int[MAX_LINE];

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            String[] s = str.split(" ");
            int x1 = Integer.parseInt(s[0]);
            int x2 = Integer.parseInt(s[1]);
            for(int j = x1+100; j<x2+100; j++){
                lineArr[j]++;
            }
        }

        int max = 0;

        for(int i = 0; i<MAX_LINE; i++){
            if(lineArr[i] > max){
                max = lineArr[i];
            }
        }

        System.out.println(max);
    }
}