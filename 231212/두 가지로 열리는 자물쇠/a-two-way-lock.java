import java.io.*;
public class Main {
    static int LEN = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] firstCombination = br.readLine().split(" ");
        String[] secondCombination = br.readLine().split(" ");
        int[] firstArr = new int[LEN];
        int[] secondArr = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            firstArr[i] = Integer.parseInt(firstCombination[i]);
            secondArr[i] = Integer.parseInt(secondCombination[i]);
        }

        //1부터 N까지 숫자를 이용해 총 3자리를 만들어야 하는 3단 다이얼이며, 숫자 1과 N이 인접한 원형으로 된 자물쇠가 하나 주어집니다.
        // 이 자물쇠는 특이해서 모든 자리에 대해 첫 번째 조합과 거리가 2 이내이거나, 모든 자리에 대해 두 번째 조합과 거리가 2 이내에 있으면 열리게 됩니다.
        //
        //예를 들어, N = 9이고 첫 번째 조합이 (1, 2, 3)이고 두 번째 조합이 (4, 5, 6)이면, 이 자물쇠는 (1, 9, 5)일 때 첫 번째 조합과 조건을 만족하게 됩니다.
        // 첫 번째 조합의 두 번째 자리인 2와 자물쇠의 두 번째 자리인 9가 조건을 만족하게 되는 이유는 N이 9 이므로 1과 9가 인접하여 거리가 2가 되기 때문입니다.
        // (2, 4, 8)인 경우에는 두 번째 조합과 조건을 만족하게 되므로 자물쇠가 열리게 됩니다. 하지만 (1, 5, 6)은 어느 하나의 단일 조합에도 근접하지 않으므로 열리지 않게 됩니다.
        //
        //N과 첫 번째 조합과 두 번째 조합이 주어졌을때 자물쇠가 열리게 되는 서로 다른 조합의 수를 구하는 프로그램을 작성해보세요. 단, (1, 2, 3)과 (3, 2, 1)은 다른 가짓수로 셉니다.

        // 입력
        //10
        //1 2 3
        //5 6 7

        //출력
        //249
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // 인접 여부를 확인한다.
                    if(isAdjacentTo(i, j, k, firstArr, n)) cnt++;
                    else if(isAdjacentTo(i, j, k, secondArr, n)) cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

    private static boolean isAdjacentTo(int i, int j, int k, int[] arr, int n) {
        return (Math.abs(arr[0] - i) <= 2 || Math.abs(arr[0] - i) >= n - 2) &&
                (Math.abs(arr[1] - j) <= 2 || Math.abs(arr[1] - j) >= n - 2) &&
                (Math.abs(arr[2] - k) <= 2 || Math.abs(arr[2] - k) >= n - 2);
    }
}