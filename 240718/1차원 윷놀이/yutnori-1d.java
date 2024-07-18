import java.io.*;
import java.util.*;
public class Main {
    private static int n,k,m,ANS;
	private static List<Integer> orders = new ArrayList<>();

	private static void bfs(int order, Person[] people){
		// 만약 order가 n과 동일해지면 people의 position이 m이 넘는 경우와 ANS 중 큰 값을 넣는다.
		if(order == n){
			int cnt = 0;
			for (int i = 0; i < k; i++) {
				if(people[i].getPosition() >= m) cnt++;
			}
			ANS = Math.max(ANS, cnt);
			return;
		}

		int movePosition = orders.get(order);
		// 모든 user가 해당 order를 수행한다.
			// people의 position을 order만큼 변경한다.
		for (int i = 0; i < k; i++) {
			if(people[i].canGo(m)) {
				people[i].plusPosition(movePosition);
				bfs(order + 1, people);
				people[i].resetPosition(movePosition);
			}
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		k = Integer.parseInt(inputs[2]);
		Person[] people = new Person[k];

		for (int i = 0; i < k; i++) {
			people[i] = new Person(i, 1);
		}

		String[] orderInput = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			orders.add(Integer.parseInt(orderInput[i]));
		}

		people[0].plusPosition(orders.get(0));
		bfs(1, people);

		System.out.println(ANS);

	}
}

class Person {
	private int userId;
	private int position;

	public Person(int userId, int position) {
		this.userId = userId;
		this.position = position;
	}

	public int getUserId() {
		return userId;
	}

	public int getPosition() {
		return position;
	}

	public void plusPosition(int addPosition) {
		this.position += addPosition;
	}

	public void resetPosition(int minusPosition) {
		this.position -= minusPosition;
	}

	public boolean canGo(int maximum){
		return this.position < maximum;
	}

}