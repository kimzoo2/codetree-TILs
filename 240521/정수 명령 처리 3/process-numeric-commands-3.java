import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] orders = br.readLine().split(" ");
			switch (orders[0]){
				case "push_front" : deque.addFirst(Integer.valueOf(orders[1])); break;
				case "push_back" : deque.addLast(Integer.valueOf(orders[1])); break;
				case "pop_front" :
					System.out.println(deque.pollFirst()); break;
				case "pop_back" :
					System.out.println(deque.pollLast()); break;
				case "size" :
					System.out.println(deque.size()); break;
				case "empty" :
					System.out.println(deque.isEmpty() ? 1 : 0); break;
				case "front" :
					System.out.println(deque.peekFirst()); break;
				case "back" :
					System.out.println(deque.peekLast()); break;
			}
		}
    }
}