import java.io.*;
class Order{
    private int distance;
    private String direction;

    public Order(int distance, String direction) {
        this.distance = distance;
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public String getDirection() {
        return direction;
    }
}
public class Main {
    static int MAX_OFFSET = 1000;
    static int MAX_N = MAX_OFFSET + 100;
    static int[] arr = new int[MAX_N];
    public static void main(String[] args) throws IOException {
        // 질의 개수를 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Order[] orders = new Order[n];

        // 이전 구간 위치를 기억할 변수를 선언한다.
        int orgIdx = MAX_OFFSET;

        // 명령만큼 반복한다.
        for(int i = 0; i<n; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");
            orders[i] = new Order(Integer.parseInt(s[0]), s[1]);
        }

        orgIdx = fillSection(orders[0], orgIdx);

        for(int i = 1; i<n; i++){
            if(!orders[i].getDirection().equals(orders[i-1].getDirection())){
                orgIdx += orders[i].getDirection().equals("R") ? 1 : -1;
            }
            orgIdx = fillSection(orders[i], orgIdx);

        }

        // 2번 이상 지나간 구간을 카운트할 변수를 선언한다.
        int cnt = 0;

        // 구간을 담을 배열만큼 반복한다.
        for (int i = 0; i < MAX_N; i++) {
            // 2번 이상 지나간 구간을 카운트 한다.
            if(arr[i] >= 2) cnt++;
        }
        System.out.println(cnt);
    }

    private static int fillSection(Order order, int orgIdx){
        int x1 = order.getDistance();
        if(order.getDirection().equals("R")){
            for(int j = orgIdx; j<orgIdx+x1; j++){
                arr[j]++;
            }
            orgIdx += x1;
        }else{
            for(int j = orgIdx; j>orgIdx-x1; j--){
                arr[j]++;
            }
            orgIdx -= x1;
        }
        return orgIdx;
    }
}