import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n];
        int[] bArr = new int[n];
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

         int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(a[i])-1;
            bArr[i] = Integer.parseInt(b[i]);
            temp[i] = bArr[i];
        }

        // 1    2    4   3  0
        // 102 103 105 104 101
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                int idx = aArr[j]; // 1 2 4 3 0
                temp[j] = bArr[idx]; // 0 = 103, 1= 105, 2= 101, 3= 104, 4=102
            }
            for (int j = 0; j < n; j++) {
                bArr[j] = temp[j];
            }
        }

        for (int i : temp) {
            System.out.println(i);
        }
    }
}