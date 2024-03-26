import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
		// push_back A: 정수 A를 동적 배열의 맨 뒤에 넣는 연산입니다.
		//
		// pop_back: 맨 뒤에 있는 정수를 하나 삭제합니다.
		//
		// size: 동적 배열에 들어있는 정수의 개수를 출력합니다.
		//
		// get k: k번째 숫자를 출력합니다.

		// 9
		// push_back 10
		// push_back 20
		// get 1
		// get 2
		// size
		// pop_back
		// size
		// get 1
		// size
		// => 10
		// 20
		// 2
		// 1
		// 10
		// 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] orders = br.readLine().split(" ");
			String order = orders[0];
			int size = list.size();
			if(order.equals("push_back")){
				list.add(Integer.valueOf(orders[1]));
			}else if(order.equals("pop_back")){
				list.remove(size-1);
			}else if(order.equals("size")){
				System.out.println(size);
			}else{
				System.out.println(list.get(Integer.parseInt(orders[1])-1));
			}
		}
	}
}