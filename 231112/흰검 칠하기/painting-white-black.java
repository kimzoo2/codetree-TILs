import java.io.*;

public class Main {
    static int OFFSET2 = 100_000;
    static int MAX_N2 = OFFSET2 * 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        OrderDTO[] orderList = new OrderDTO[n];
        int curIdx = OFFSET2;
        int[][] sectionArr = new int[MAX_N2][2];
        char[] directionArr = new char[MAX_N2];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] strings = str.split(" ");
            int x = Integer.parseInt(strings[0]);
            if (strings[1].equals("R")) {
                orderList[i] = new OrderDTO(curIdx, x == 1 ? curIdx : curIdx + x -1, strings[1].charAt(0));
                curIdx += x - 1;
            } else if(strings[1].equals("L") ) {
                orderList[i] = new OrderDTO(x == 1 ? curIdx : curIdx - x + 1, curIdx, strings[1].charAt(0));
                curIdx -= x - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (orderList[i].getDirection() == 'R') {
                for (int j = orderList[i].getFirstIdx(); j <= orderList[i].getSecondIdx(); j++) {
                    sectionArr[j][0]++;
                    directionArr[j] = orderList[i].getDirection();
                }
            } else if (orderList[i].getDirection() == 'L') {
                for (int j = orderList[i].getSecondIdx(); j >= orderList[i].getFirstIdx(); j--) {
                    sectionArr[j][1]++;
                    directionArr[j] = orderList[i].getDirection();
                }
            }
        }
        int whiteSection = 0;
        int blackSection = 0;
        int graySection = 0;
        for (int i = 0; i < MAX_N2; i++) {
            if (sectionArr[i][0] >= 2 && sectionArr[i][1] >= 2) {
                graySection++;
                continue;
            }
            if (directionArr[i] == 'L') {
                whiteSection++;
            } else if (directionArr[i] == 'R') {
                blackSection++;
            }
        }
        System.out.println(whiteSection + " " + blackSection + " " + graySection);
    }
}

class OrderDTO {
    private int firstIdx;
    private int secondIdx;
    private char direction;

    public OrderDTO(int firstIdx, int secondIdx, char direction) {
        this.firstIdx = firstIdx;
        this.secondIdx = secondIdx;
        this.direction = direction;
    }

    public int getFirstIdx() {
        return firstIdx;
    }

    public int getSecondIdx() {
        return secondIdx;
    }

    public char getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "firstIdx=" + firstIdx +
                ", secondIdx=" + secondIdx +
                ", direction=" + direction +
                '}';
    }
}