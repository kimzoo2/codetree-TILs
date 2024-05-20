import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String[] orders = br.readLine().split(" ");
			switch (orders[0]){
				case "push" : queue.add(Integer.valueOf(orders[1])); break;
				case "pop" :
					System.out.println(queue.poll()); break;
				case "size" :
					System.out.println(queue.size()); break;
				case "empty" :
					System.out.println(queue.isEmpty()? 1 : 0); break;
				case "front" :
					System.out.println(queue.peek()); break;
			}
		}
    }
}