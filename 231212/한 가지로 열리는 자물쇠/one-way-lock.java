import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1부터 N까지 숫자를 중복해서 뽑아 총 3자리를 만들어야 하는 자물쇠가 하나 주어집니다. 이 자물쇠는 특이해서 한 자리라도 주어지는 조합과 거리가 2 이내라면 열리게 됩니다.
        //
        // 예를 들어, N = 6이고 주어진 조합이 (1, 2, 3) 이라면, 이 자물쇠는 (5, 4, 6)일 때 두 번째 자리의 숫자 차이가 2 이내가 되므로 열리게 됩니다.
        // 자물쇠 번호가 (1, 5, 6)인 경우에는 첫 번째 자리의 숫자 차이가 2 이내가 되므로 열리게 됩니다.
        // 만약 자물쇠 번호가 (6, 6, 6) 이라면 숫자 차이가 2 이내인 위치가 없으므로 열리지 않습니다.
        //
        //ㅍN과 조합이 주어졌을때 자물쇠가 열리게 되는 서로 다른 조합의 수를 구하는 프로그램을 작성해보세요. 단, (1, 2, 3)과 (3, 2, 1)은 다른 가짓수로 셉니다.
        //입력
        //6
        //1 2 3
        //출력
        //210

        int n = Integer.parseInt(br.readLine());
        String[] combination = br.readLine().split(" ");
        int a = Integer.parseInt(combination[0]);
        int b = Integer.parseInt(combination[1]);
        int c = Integer.parseInt(combination[2]);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(Math.abs(i-a) <= 2 || Math.abs(j-b) <=2 || Math.abs(k-c) <=2) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}