import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String order = sc.next();

			if(order.equals("push_front")){
				int num = sc.nextInt();
				list.addFirst(num);
			}else if(order.equals("push_back")){
				int num = sc.nextInt();
				list.add(num);
			}else if(order.equals("pop_front")){
				Integer first = list.pollFirst();
				System.out.println(first);
			}else if(order.equals("pop_back")){
				Integer last = list.pollLast();
				System.out.println(last);
			}else if(order.equals("size")){
				System.out.println(list.size());
			}else if(order.equals("empty")){
				System.out.println(list.isEmpty() ? 1 : 0);
			}else if(order.equals("front")){
				System.out.println(list.peekFirst());
			}else if(order.equals("back")){
				System.out.println(list.peekLast());
			}
		}
	}
}