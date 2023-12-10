import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n];
        int[] bArr = new int[n];
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(a[i])-1; // 2
            bArr[idx] = Integer.parseInt(b[i]); // 2 = 102;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(bArr[i]);
        }
    }
}