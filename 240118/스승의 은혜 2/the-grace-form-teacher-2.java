import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int budget = sc.nextInt();
        int[] students = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            students[i] = sc.nextInt();
        }

        Arrays.sort(students);

        int max = 0;

        for (int i = 0; i < cnt; i++) {
            int ans = 0;
            int sum = 0;
            for (int j = 0; j < cnt; j++) {
                int price = students[j];
                if(i == j) price /= 2;
                sum += price;
                if(sum > budget) break;
                ans++;
            }
            max = Math.max(ans, max);
        }

        System.out.println(max);
    }
}