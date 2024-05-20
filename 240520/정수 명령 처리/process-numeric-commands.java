import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			String[] orders = br.readLine().split(" ");
			switch(orders[0]){
				case "push" : stack.push(Integer.valueOf(orders[1])); break;
				case "size" :
					System.out.println(stack.size()); break;
				case "empty" :
					System.out.println(stack.isEmpty() ? 1 : 0); break;
				case "pop" :
					System.out.println(stack.pop()); break;
				case "top" :
					System.out.println(stack.peek()); break;
				default:
			}
		}
    }
}