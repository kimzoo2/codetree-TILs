import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int cnt = Integer.parseInt(split[0]);
        int budget = Integer.parseInt(split[1]);
        Present[] presents = new Present[cnt];

        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");
            Present present = new Present(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            presents[i] = present;
        }

        Arrays.sort(presents);
        int ans = 0;
        for (int i = 0; i < cnt; i++) {
            int n = 0;
            int sum = 0;
            for (int j = 0; j < cnt; j++) {
                int presentPrice = presents[j].price;
                if(i == j)
                    presentPrice = presents[i].sum;
                sum += presentPrice;
                if(budget < sum) break;
                n++;
            }
            ans = Math.max(ans, n);
        }

        System.out.println(ans);

        // 5 24
        // 4 2
        // 2 0
        // 8 1
        // 6 3
        // 12 5
    }

    static class Present implements Comparable<Present> {
        private int price;
        private int shipFee;
        private int sum;

        public Present(int price, int shipFee) {
            this.price = price;
            this.shipFee = shipFee;
            this.sum = price/2 + shipFee;
        }

        public int getPrice() {
            return price;
        }

        public int getShipFee() {
            return shipFee;
        }

        public int getSum() {
            return sum;
        }

        @Override
        public int compareTo(Present o) {
            if(this.sum != o.sum)
                return this.sum - o.sum;
            return this.shipFee - o.shipFee;
        }
    }
}