import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] lights = new int[n+1];
        String[] lightsInput = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            lights[i] = Integer.parseInt(lightsInput[i-1]);
        }

        for (int i = 0; i < m; i++) {
            String[] query = br.readLine().split(" ");
            int a = Integer.parseInt(query[0]);
            int b = Integer.parseInt(query[1]);
            int c = Integer.parseInt(query[2]);

            if(a == 1){
                lights[b] = c;
            }else if(a == 2){
                for (int j = b; j <= c; j++) {
                    lights[j] = 1 - lights[j];
                }
            }else if(a == 3){
                for (int j = b; j <= c; j++) {
                    lights[j] = 0;
                }
            }else{
                for (int j = b; j <= c; j++) {
                    lights[j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(lights[i] + " ");
        }
    }
}