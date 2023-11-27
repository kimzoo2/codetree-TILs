import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] cattle = br.readLine().split(" ");
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(Integer.parseInt(cattle[i]) <= Integer.parseInt(cattle[j]) &&
                            Integer.parseInt(cattle[j]) <= Integer.parseInt(cattle[k]))
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}